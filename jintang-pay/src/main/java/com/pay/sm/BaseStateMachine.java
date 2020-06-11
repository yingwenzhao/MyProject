package com.pay.sm;

import com.pay.helper.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigInteger;
import java.util.HashMap;

@Slf4j
public abstract class BaseStateMachine implements SMLoder, ApplicationListener<ContextRefreshedEvent> {


    private HashMap<String, Transition> transitionMap = new HashMap<String, Transition>();

    @Autowired
    private SpringContextHolder contextHolder;
    @Autowired
    private TransactionTemplate transactionTemplate;

    public void addTransition(String currentState, String event, String targetState, String successStateEvent, String failStateEvent) {
        Transition transition = new Transition(currentState, event, targetState, successStateEvent, failStateEvent);
        transitionMap.put(transition.getKey(), transition);
    }

    public void onApplicationEvent(ContextRefreshedEvent var1) {
        load();
    }

    public void push(final Statable statableModel, final String event) {
        String currentState = statableModel.getStatus();
        Transition transition = transitionMap.get(Transition.getKey(currentState, event));
        BigInteger id = statableModel.getId();
        if (transition == null || id == null) {
            throw new StateMachineException("0999", "不允许的状态迁移");
        }

        Event successStateEvent = getEventBean(transition.getSuccessStateEvent());
        Event failStateEvent = getEventBean(transition.getFailStateEvent());

        Boolean result = transactionTemplate.execute(transactionStatus -> {
            try {
                int doPushResult = doPush(currentState, transition.getTargetState(), statableModel);
                if (doPushResult > 1) {
                    transactionStatus.setRollbackOnly();
                    return false;
                } else if (doPushResult == 1) {
                    statableModel.setStatus(transition.getTargetState());
                    if (successStateEvent != null) {
                        successStateEvent.withinTransaction(statableModel);
                    }
                } else {
                    if (failStateEvent != null) {
                        failStateEvent.withinTransaction(statableModel);
                    }
                }
                return doPushResult == 1;
            } catch (Exception e) {
                transactionStatus.setRollbackOnly();
                return false;
            } finally {
                if (transactionStatus.isRollbackOnly()) {
                    statableModel.setStatus(currentState);
                }
            }
        });

        try {
            if (result) {
                if (successStateEvent != null) {
                    successStateEvent.withoutTransaction(statableModel);
                }
            } else {
                if(failStateEvent != null){
                    failStateEvent.withoutTransaction(statableModel);
                }
            }
        } catch (Exception e) {
            /**
             * 该异常不应影响交易主流程，即属于二级事件
             */
            log.error("状态迁移事务外事件执行异常",e);
        }

        if(!result){
            throw new StateMachineException("0999","状态迁移失败");
        }
    }

    protected Event getEventBean(String beanName) {
        if (StringUtils.isNotBlank(beanName)) {
            if (contextHolder.containsBean(beanName)) {
                Event event = (Event) contextHolder.getBean(beanName);
                return event;
            } else {
                log.info("当前状态事件未定义beanName={}", beanName);
            }
        }
        return null;
    }

    /**
     * 使用数据库乐观锁推动状态改变
     * @param currentState
     * @param targetState
     * @param statableModel
     * @return
     */
    public abstract int doPush(String currentState, String targetState, Statable statableModel);

}

package com.jintang.process;

import com.jintang.context.JintangContext;
import com.jintang.handler.JintangHandler;
import constants.SysCodeConstants;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Getter
@Setter
@Slf4j
public abstract class AbstractProcess<Q, S> implements Process<Q, S> {

    private List<JintangHandler<Q, S>> handlers;
    private List<JintangHandler<Q, S>> finallyHandlers;



    public void process(JintangContext<Q, S> context) {
        log.info("{}.process begin !!!", this.getClass().getName());
        try {
            if (!CollectionUtils.isEmpty(handlers)) {
                for (JintangHandler handler : handlers) {
                    handler.handler(context);
                    if(!SysCodeConstants.SUCCESS.getCode().equals(context.getRespCode())){
                        log.info("{} 执行出现非预期返回 code={},message = {}",handler.getClass().getName(),context.getRespCode(),context.getRespTest());
                        return;
                    }
                }
            }
        } catch (Exception e) {

            if(SysCodeConstants.SUCCESS.getCode().equals(context.getRespCode())){
                context.setRespCode(SysCodeConstants.EXCEPTIONS.getCode());
                context.setRespTest(SysCodeConstants.EXCEPTIONS.getMessage());
            }

        } finally {
            /**
             *    交易返回后必须处理步逐
             */
            try {
                if (!CollectionUtils.isEmpty(finallyHandlers)) {
                    for (JintangHandler handler : finallyHandlers) {
                        handler.handler(context);
                    }
                }
            } catch (Exception e) {

            }


        }
    }


}

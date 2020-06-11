package com.jintang.process;

import com.jintang.context.JintangContext;
import com.jintang.exception.StepExitException;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;
@Slf4j
public abstract class BaseExecStep {

    public Step beginFlow(JintangContext context,Function<JintangContext,String > currentProcess){
        return new Step(currentProcess,context);
    }

    public String endFlow(JintangContext context){
        return null;
    }

    public String breakFlow(JintangContext context){
        throw new StepExitException("工作流程异常跳出");
    }

    public void exceptionExecute(JintangContext context){
        log.info("当前执行异常context={}",context);
        //告警等异常处理
    }

    public void finallyExeute(JintangContext context){
        //finally块执行
    }

}

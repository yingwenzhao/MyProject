package com.jintang.process;

import com.jintang.context.JintangContext;
import com.jintang.exception.BizException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.function.Function;

@Slf4j
@Getter
@Setter
public class Step {

    private Function<JintangContext,String> currentProcess;

    private String currentResult;

    private JintangContext context;

    public Step(Function<JintangContext, String> currentProcess, JintangContext context) {
        this.currentProcess = currentProcess;
        this.context = context;
    }

    public Step handle(String result,Function<JintangContext,String > nextProcess){
        if (currentProcess == null){
            throw new BizException("当前流程步骤初始化为空！！！");
        }
        if(StringUtils.isBlank(this.currentResult)){
            this.currentResult = currentProcess.apply(this.context);
        }
        if(StringUtils.isNotBlank(this.currentResult) && currentResult.equals(result)){
            return new Step(nextProcess,context);
        }
        return this;
    }

    public void endFlow(){
        this.currentResult = currentProcess.apply(context);
    }


    @Override
    public String toString() {
        return "Step{" +
                "currentResult='" + currentResult + '\'' +
                '}';
    }
}

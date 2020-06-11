package test.stepflowtest;


import com.jintang.context.JintangContext;
import com.jintang.process.BaseExecStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StepFlowImpl extends BaseExecStep {

    public String checkDate(JintangContext context) {
        log.info("{}.checkDate excute!!", this);

        return "S";
    }

    public String merchantCheck(JintangContext context) {
        log.info("{}.merchantCheck 被调用", this);
        return "S";
    }

    public String orderLand(JintangContext context) {
        log.info("{}.orderLand 被调用", this);
        return "S";
    }




}

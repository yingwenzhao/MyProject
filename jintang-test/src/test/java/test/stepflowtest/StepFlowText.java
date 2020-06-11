package test.stepflowtest;

import base.JintangTest;
import com.jintang.context.JintangContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

@Slf4j
public class StepFlowText extends JintangTest {

    @Autowired
    private StepFlowImpl stepFlow;

    @Test
    public void test() {
        JintangContext context = new TestContext();
        context.setReqBean("当前是请求对象");
        try {
            stepFlow.beginFlow(context, stepFlow::checkDate)

                    .handle("F", stepFlow::breakFlow)
                    .handle("S", stepFlow::merchantCheck)

                    .handle("S", stepFlow::orderLand)

                    .handle("S", stepFlow::breakFlow)
                    .endFlow();
        } catch (Exception e) {
            log.error("{},",toString(),e);
            stepFlow.exceptionExecute(context);
        } finally {
            stepFlow.finallyExeute(context);
        }

    }
}

package base;

import lombok.extern.slf4j.Slf4j;
import mock.MockConfiguration;
import mock.MockContext;
import mock.MockInfo;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.util.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;
import java.sql.Time;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class BaseTest extends AbstractTestNGSpringContextTests {

    @BeforeTest
    public void beforeTest(){
        log.info("class BaseTest extends AbstractTestNGSpringContextTests begin!!!");
    }


    @BeforeMethod
    protected void parseMockConfiguration(Method method) throws Exception{
        MockConfiguration mockConfiguration = method.getAnnotation(MockConfiguration.class);

        if(mockConfiguration != null && mockConfiguration.value() != null && mockConfiguration.value().length > 0){

            String mockInfo = mockConfiguration.info();

            for (String mock : mockConfiguration.value()){

                String[] split = mock.split(",");

                Assert.isTrue(split.length>=0);

                String mockClass = split[0].trim();
                String mockType = split[1].trim();
                String callingStackPattern = mock.substring(mock.indexOf(",", mockClass.length() + 2) + 1);
                if(MockInfo.ASYNC_FAIL.equals(mockType)||MockInfo.ASYNC_SUCCESS.equals(mockType)){
                    ReentrantLock lock = new ReentrantLock();
                    Condition condition = lock.newCondition();
                    lock.lock();
                    MockContext.addMockInfo(Class.forName(mockClass),mockType,lock,condition,mockInfo,callingStackPattern.split(","));
                }else {
                    MockContext.addMockInfo(Class.forName(mockClass),mockType,mockInfo,callingStackPattern.split(","));
                }

            }
        }

        log.debug("当前测试方法{}，初始化mock信息={}",method.getName(),MockContext.getMockList());
    }


    @AfterMethod
    public void resetContext(Method method){
        MockContext.resetContext();
    }

    public static void main(String[] args) {
        System.out.println(Time.class.getName());
    }


}

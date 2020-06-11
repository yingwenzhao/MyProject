package base;

import lombok.extern.slf4j.Slf4j;
import mock.MockFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Slf4j
public class BaseTestBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private MockFactory mockFactory;

    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {

        log.debug("BaseTestBeanPostProcessor.postProcessAfterInitialization bean :{},beanName : {}",bean.getClass(),s);

        Set<Class> mockTypes = mockFactory.getMockType();

        Class<?>[] interfaces = bean.getClass().getInterfaces();

        for (Class<?> interfaceClass : interfaces){
            if(mockTypes.contains(interfaceClass)){
                Object mockBean = mockFactory.createMockByInterface(interfaceClass);
                if(mockBean != null){
                    log.debug("当前mock对象：{}",interfaceClass);
                    return mockBean;
                }
            }
        }

        return bean;
    }
}

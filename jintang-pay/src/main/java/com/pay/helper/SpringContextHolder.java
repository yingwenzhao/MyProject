package com.pay.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextHolder implements ApplicationContextAware {

    private ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public boolean containsBean(String beanName){
        return context.containsBean(beanName);
    }

}

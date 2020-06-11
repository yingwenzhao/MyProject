package com.jintang.springevent;

import dao.OrderMapper;
import model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent>, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private OrderMapper orderMapper;

    private Logger log = LoggerFactory.getLogger("com.jintang.springevent.MyApplicationListener");

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        JdbcTemplate template = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        Date date = template.queryForObject("select now()", Date.class);
        log.info("com.jintang.springevent.MyApplicationListener date ={}",date);

        Order order = new Order();
        order.setCustId("10000009999");
        int insert = orderMapper.insert(order);
        log.info("com.jintang.springevent.MyApplicationListener orderMapper.insert ={}",insert);

    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

package com.jintang.configuration;

import com.jintang.service.impl.DahuaAccountImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhaoyingwen
 * @Description 上下文配置bean$
 * @Date 2019/9/20
 **/
@Configuration
public class AccountConfigBean {
    @Bean
    public DahuaAccountImpl getDahuaAccountImpl(){
        return new DahuaAccountImpl();
    }
}

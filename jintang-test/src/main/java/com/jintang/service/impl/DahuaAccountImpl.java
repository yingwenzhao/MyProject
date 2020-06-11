package com.jintang.service.impl;

import com.jintang.service.Account;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Component
public class DahuaAccountImpl implements Account {
    public void getAccountName(){
        System.out.println("hhhhahahahaha");
    }

    public static void main(String[] args) {
        Account account = new DahuaAccountImpl();
        System.out.println(account.getClass());
        Class<? extends Account> aClass = account.getClass();
        Annotation[] annotations = aClass.getAnnotations();
        System.out.println(annotations);
    }
}

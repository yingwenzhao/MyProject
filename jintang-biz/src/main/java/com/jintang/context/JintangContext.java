package com.jintang.context;

import lombok.Data;

@Data
public abstract class JintangContext<Q, S> {

    private String respCode;

    private String respTest;

    private Q reqBean;

    private S resBean;


}

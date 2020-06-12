package com.jintang.handler;

import com.jintang.context.JintangContext;

public interface JintangHandler<Q,S> {

    void handler(JintangContext<Q,S> context);




}

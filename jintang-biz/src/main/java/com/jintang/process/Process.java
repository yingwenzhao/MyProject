package com.jintang.process;

import com.jintang.context.JintangContext;

public interface Process<Q,S>{

    void process(JintangContext<Q,S> context);

}

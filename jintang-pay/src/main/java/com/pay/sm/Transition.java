package com.pay.sm;

import lombok.Data;

@Data
public class Transition {

    private String currentState;

    private String event;

    private String targetState;

    private String successStateEvent;

    private String failStateEvent;

    public Transition(String currentState, String event, String targetState, String successStateEvent, String failStateEvent) {
        this.currentState = currentState;
        this.event = event;
        this.targetState = targetState;
        this.successStateEvent = successStateEvent;
        this.failStateEvent = failStateEvent;
    }

    public String getKey(){
        return getKey(this);
    }

    public static String getKey(Transition transition){
        return getKey(transition.getCurrentState(),transition.getEvent());
    }

    public static String getKey(String currentState,String event){
        return currentState+"#"+event;
    }



}

package com.pay.sm.impl;

import com.pay.sm.BaseStateMachine;
import com.pay.sm.Statable;
import org.springframework.stereotype.Component;

@Component
public class PaymentStateMachine extends BaseStateMachine {


    public static final class PrepareEvent {
        public static final String SUCCESS = "prepare_success";
        public static final String FAIL = "prepare_fail";
    }

    public static final class ConfirmEvent{
        public static final String SUCCESS = "confirm_success";
        public static final String FAIL = "confirm_fail";
        public static final String ERROR = "confirm_error";
    }
    public static final class CancelEvent{
        public static final String SUCCESS = "cancel_success";
        public static final String FAIL = "cancel_fail";
        public static final String ERROR = "cancel_error";
    }

    public static final class Status{
        public static final String INITIAL = "initial";
        public static final String CONFIRMING = "confirming";
        public static final String CANCELING = "canceling";
        public static final String MANUAL = "manual";
        public static final String SUCCESS = "success";
        public static final String FAIL = "fail";
    }


    public int doPush(String currentState, String targetState, Statable statableModel) {
        return 0;
    }

    public void load() {
        addTransition(Status.INITIAL,PrepareEvent.SUCCESS,Status.CONFIRMING,null,null);
        addTransition(Status.INITIAL,PrepareEvent.FAIL,Status.FAIL,null,null);

        addTransition(Status.CONFIRMING,ConfirmEvent.SUCCESS,Status.SUCCESS,null,null);
        addTransition(Status.CONFIRMING,ConfirmEvent.FAIL,Status.CANCELING,null,null);
        addTransition(Status.CONFIRMING,ConfirmEvent.ERROR,Status.MANUAL,null,null);

        addTransition(Status.CANCELING,CancelEvent.SUCCESS,Status.FAIL,null,null);
        addTransition(Status.CANCELING,CancelEvent.ERROR,Status.MANUAL,null,null);
        addTransition(Status.CANCELING,CancelEvent.FAIL,Status.MANUAL,null,null);

    }
}

package com.pay.sm;

public class StateMachineException extends RuntimeException {

    protected String code;


    public StateMachineException(String code) {
        this.code = code;
    }

    public StateMachineException(String message, String code) {
        super(message);
        this.code = code;
    }

    public StateMachineException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public StateMachineException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public StateMachineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}

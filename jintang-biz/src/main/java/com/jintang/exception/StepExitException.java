package com.jintang.exception;

public class StepExitException extends RuntimeException {

    String code;

    public StepExitException(String code) {
        this.code = code;
    }

    public StepExitException(String message, String code) {
        super(message);
        this.code = code;
    }

    public StepExitException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public StepExitException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public StepExitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    @Override
    public String toString() {
        return "StepExitException{" +
                "code='" + code + '\'' +
                '}' + getMessage();
    }
}

package com.jintang.exception;

import lombok.Data;

@Data
public class DBException extends Exception {

    private String code;

    public DBException(String code) {
        this.code = code;
    }

    public DBException(String message, String code) {
        super(message);
        this.code = code;
    }

    public DBException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public DBException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public DBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}

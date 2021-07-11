package com.thangnv.booking.controller.exception;

public class MissingQueryParamException extends RuntimeException {
    public MissingQueryParamException() {
        super();
    }

    public MissingQueryParamException(String message) {
        super(message);
    }

    public MissingQueryParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingQueryParamException(Throwable cause) {
        super(cause);
    }

    protected MissingQueryParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

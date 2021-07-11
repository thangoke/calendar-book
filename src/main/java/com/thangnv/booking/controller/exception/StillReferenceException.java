package com.thangnv.booking.controller.exception;

public class StillReferenceException extends RuntimeException {
    public StillReferenceException() {
        super();
    }

    public StillReferenceException(String message) {
        super(message);
    }

    public StillReferenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public StillReferenceException(Throwable cause) {
        super(cause);
    }

    protected StillReferenceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

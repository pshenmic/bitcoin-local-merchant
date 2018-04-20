package com.pshenmic.exception;

public class UnknownCurrencyException extends Exception {
    public UnknownCurrencyException() {
    }

    public UnknownCurrencyException(String message) {
        super(message);
    }

    public UnknownCurrencyException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownCurrencyException(Throwable cause) {
        super(cause);
    }

    public UnknownCurrencyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.pshenmic.exception;

public class ElectrumRequestFailedException extends Exception {

    public ElectrumRequestFailedException() {
    }

    public ElectrumRequestFailedException(String message) {
        super(message);
    }

    public ElectrumRequestFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElectrumRequestFailedException(Throwable cause) {
        super(cause);
    }

    public ElectrumRequestFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.pshenmic.exception;

public class OperationPriceExtractingException extends Exception {

    public OperationPriceExtractingException() {
    }

    public OperationPriceExtractingException(String message) {
        super(message);
    }

    public OperationPriceExtractingException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperationPriceExtractingException(Throwable cause) {
        super(cause);
    }

    public OperationPriceExtractingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

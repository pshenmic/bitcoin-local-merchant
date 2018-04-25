package com.pshenmic.exception;

public class OrderStatusMappingFailedException extends Exception {

    public OrderStatusMappingFailedException() {
    }

    public OrderStatusMappingFailedException(String message) {
        super(message);
    }

    public OrderStatusMappingFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderStatusMappingFailedException(Throwable cause) {
        super(cause);
    }

    public OrderStatusMappingFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.pshenmic.controller;

import com.pshenmic.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {

    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE,
            reason = "Operation price extracting exception")
    @ExceptionHandler(OperationPriceExtractingException.class)
    public void operationPriceExtractingException() {
    }

    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE,
            reason = "Unknown currency exception")
    @ExceptionHandler(UnknownCurrencyException.class)
    public void unknownCurrencyException() {
    }

    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE,
            reason = "Unknown currency exception")
    @ExceptionHandler(ElectrumRequestFailedException.class)
    public void electrumRequestFailedException() {
    }

    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE,
            reason = "Unknown currency exception")
    @ExceptionHandler(OrderStatusMappingFailedException.class)
    public void orderStatusMappingFailedException() {
    }

}
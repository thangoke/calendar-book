package com.thangnv.booking.controller.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {MissingQueryParamException.class})
    protected ResponseEntity<Object> handleMissingQueryParamException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = String.format("[Missing-param] %s", ex.getLocalizedMessage());
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {DataNotFoundException.class})
    protected ResponseEntity<Object> handleDataNotFoundException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = String.format("[Data-not-found] %s", ex.getLocalizedMessage());
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {StillReferenceException.class})
    protected ResponseEntity<Object> handleStillReferenceException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = String.format("[Still-reference] %s", ex.getLocalizedMessage());
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = {DateFormatException.class})
    protected ResponseEntity<Object> handleDateFormatException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = String.format("[Date-time-format] %s", ex.getLocalizedMessage());
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
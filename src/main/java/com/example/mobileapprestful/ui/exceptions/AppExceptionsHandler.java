package com.example.mobileapprestful.ui.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// ResponseEntityExceptionHandler provides exception covering across ALL request mapping
@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    //  Method that handles the exception must be annotated with @ExceptionHandler
//  For specific exceptions, change the value passed inside @ExceptionHandler
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}

package com.example.mobileapprestful.ui.exceptions;

import com.example.mobileapprestful.ui.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

// ResponseEntityExceptionHandler provides exception covering across ALL request mapping
@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    //  Method that handles the exception must be annotated with @ExceptionHandler
//  For specific exceptions, change the value passed inside @ExceptionHandler
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();
        if (errorMessageDescription == null)
            errorMessageDescription = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

//      errorMessage is now the response body
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    //  This method specifically handles null pointer exception(s).
    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();
        if (errorMessageDescription == null)
            errorMessageDescription = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

//      errorMessage is now the response body
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();
        if (errorMessageDescription == null)
            errorMessageDescription = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);

//      errorMessage is now the response body
        return new ResponseEntity<>(
                errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}

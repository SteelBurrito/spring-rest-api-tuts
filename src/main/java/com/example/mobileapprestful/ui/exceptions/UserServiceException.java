package com.example.mobileapprestful.ui.exceptions;

public class UserServiceException extends RuntimeException {
    private static final long serialVersionUID = 7724519688032402429L;

    public UserServiceException(String message) {
        super(message);
    }
}

package com.example.toygry.exception;

import org.springframework.http.HttpStatus;

public class InvalidUserException extends BaseException {
    public InvalidUserException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }

    public InvalidUserException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}

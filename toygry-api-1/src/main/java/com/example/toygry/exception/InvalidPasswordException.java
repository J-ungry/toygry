package com.example.toygry.exception;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends BaseException {
    public InvalidPasswordException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }

    public InvalidPasswordException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}

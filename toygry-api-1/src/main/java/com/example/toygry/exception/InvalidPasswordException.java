package com.example.toygry.exception;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

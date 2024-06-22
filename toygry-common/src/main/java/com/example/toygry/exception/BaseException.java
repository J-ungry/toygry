package com.example.toygry.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException {

    private final HttpStatus status;
    private final String message;

    public BaseException(String message, HttpStatus status) {
        this.status = status;
        this.message = message;
    }
}

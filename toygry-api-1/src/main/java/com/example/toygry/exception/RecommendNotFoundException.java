package com.example.toygry.exception;


import org.springframework.http.HttpStatus;

public class RecommendNotFoundException extends BaseException {
    public RecommendNotFoundException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }

    public RecommendNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}

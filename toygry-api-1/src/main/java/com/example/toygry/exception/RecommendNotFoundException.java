package com.example.toygry.exception;

import org.springframework.http.HttpStatus;

public class RecommendNotFoundException extends RuntimeException{
    public RecommendNotFoundException(String message) {
        super(message);
    }
}

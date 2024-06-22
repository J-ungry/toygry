package com.example.toygry.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorResponse {

    private final HttpStatus status;
    private final String message;

    public ErrorResponse(BaseException e) {
        this.status = e.getStatus();
        this.message = e.getMessage();
    }
}
package com.example.toygry.dto;

import lombok.Getter;

@Getter
public class CheckPasswordRecommendRequest {

    private final String id;
    private final String password;

    private CheckPasswordRecommendRequest(String id, String password) {
        this.id = id;
        this.password = password;
    }
}

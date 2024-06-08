package com.example.toygry.dto;

import lombok.Getter;

@Getter
public class DeleteRecommendRequest {

    private final String id;
    private final String password;

    private DeleteRecommendRequest(String id, String password) {
        this.id = id;
        this.password = password;
    }
}

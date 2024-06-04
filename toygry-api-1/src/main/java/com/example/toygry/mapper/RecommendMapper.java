package com.example.toygry.mapper;

import com.example.toygry.dto.RecommendResponse;
import com.example.toygry.entity.Recommend;

public class RecommendMapper {
    // entity -> dto
    public static RecommendResponse toDto(Recommend recommend) {
        if (recommend == null) {
            return null;
        }

        return RecommendResponse.builder()
                .id(recommend.getId())
                .userId(recommend.getUserId())
                .password(recommend.getPassword())
                .recommendType(recommend.getRecommendType())
                .title(recommend.getTitle())
                .contents(recommend.getContents())
                .image(recommend.getImage())
                .createdDate(recommend.getCreatedDate())
                .modifiedDate(recommend.getModifiedDate())
                .build();
    }

    // dto -> entity
    public static Recommend toEntity(RecommendResponse recommendResponse) {
        if (recommendResponse == null) {
            return null;
        }

        return Recommend.builder()
                .id(recommendResponse.getId())
                .userId(recommendResponse.getUserId())
                .password(recommendResponse.getPassword())
                .recommendType(recommendResponse.getRecommendType())
                .title(recommendResponse.getTitle())
                .contents(recommendResponse.getContents())
                .image(recommendResponse.getImage())
                .createdDate(recommendResponse.getCreatedDate())
                .modifiedDate(recommendResponse.getModifiedDate())
                .build();
    }
}

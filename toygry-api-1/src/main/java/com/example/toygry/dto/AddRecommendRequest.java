package com.example.toygry.dto;

import com.example.toygry.entity.RecommendType;
import lombok.Getter;

// Recommend 생성을 하기 위한 request

@Getter
public class AddRecommendRequest {
    private String userId;
    private String password;
    private RecommendType recommendType;
    private String title;
    private String contents;
    private String image;

//     @AllArgsConstructor
    private AddRecommendRequest(String userId,String password, RecommendType recommendType, String title, String contents, String image) {
        this.userId = userId;
        this.password = password;
        this.recommendType = recommendType;
        this.title = title;
        this.contents = contents;
        this.image = image;
    }

    // @Builder
    public static class Builder {
        private String userId;
        private String password;
        private RecommendType recommendType;
        private String title;
        private String contents;
        private String image;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }
        public Builder recommendType(RecommendType recommendType) {
            this.recommendType = recommendType;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder contents(String contents) {
            this.contents = contents;
            return this;
        }
        public Builder image(String image) {
            this.image = image;
            return this;
        }
        public AddRecommendRequest build() {
            return new AddRecommendRequest(userId,password, recommendType, title, contents, image);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}

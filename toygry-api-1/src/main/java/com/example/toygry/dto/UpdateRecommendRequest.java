package com.example.toygry.dto;

import com.example.toygry.entity.RecommendType;
import lombok.Getter;

@Getter
public class UpdateRecommendRequest {
    private final RecommendType recommendType;
    private final String title;
    private final String contents;
    private final String image;

    private UpdateRecommendRequest(RecommendType recommendType, String title, String contents, String image) {
        this.recommendType = recommendType;
        this.title = title;
        this.contents = contents;
        this.image = image;
    }

    public static class Builder {
        private RecommendType recommendType;
        private String title;
        private String contents;
        private String image;
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
        public UpdateRecommendRequest build() {
            return new UpdateRecommendRequest(recommendType, title, contents, image);
        }
    }
}

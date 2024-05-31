package com.example.toygry.dto;

import com.example.toygry.entity.RecommendType;

import java.time.LocalDateTime;

// Recommend 객체에 대한 response
public class RecommendResponse {
    private String id;
    private String userId;
    private String password;
    private RecommendType recommendType;
    private String title;
    private String contents;
    private String image;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    // @NoArgsConstructor
    public RecommendResponse() {}

    // @AllArgsConstructor
    private RecommendResponse(String id, String userId, String password, RecommendType recommendType, String title, String contents, String image, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.recommendType = recommendType;
        this.title = title;
        this.contents = contents;
        this.image = image;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    // @Getter
    public String getId() {return id;}
    public String getUserId() {return userId;}
    public String getPassword() {return password;}
    public RecommendType getRecommendType() {return recommendType;}
    public String getTitle() {return title;}
    public String getContents() {return contents;}
    public String getImage() {return image;}
    public LocalDateTime getCreatedDate() {return createdDate;}
    public LocalDateTime getModifiedDate() {return modifiedDate;}

    // @Builder
    public static class Builder {
        private String id;
        private String userId;
        private String password;
        private RecommendType recommendType;
        private String title;
        private String contents;
        private String image;
        private LocalDateTime createdDate;
        private LocalDateTime modifiedDate;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
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
        public Builder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }
        public Builder modifiedDate(LocalDateTime modifiedDate) {
            this.modifiedDate = modifiedDate;
            return this;
        }

        public RecommendResponse build() {
            return new RecommendResponse(id, userId, password, recommendType, title, contents, image, createdDate, modifiedDate);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

}

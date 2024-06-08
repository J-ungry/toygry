package com.example.toygry.entity;

import com.example.toygry.dto.AddRecommendRequest;
import com.example.toygry.dto.UpdateRecommendRequest;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "recommend")
@Getter
public class Recommend {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "recommend_type", columnDefinition = "recommend_type")
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private RecommendType recommendType;

    @Column(name = "title")
    private String title;

    @Column(name = "contents")
    private String contents;

    @Column(name = "image")
    private String image;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    // @NoArgsConstructor
    public Recommend() {}

    // @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private Recommend(String id, String userId, String password, RecommendType recommendType, String title, String contents, String image, LocalDateTime createdDate, LocalDateTime modifiedDate) {
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

        public Recommend build() {
            return new Recommend(id, userId, password, recommendType, title, contents, image, createdDate, modifiedDate);
        }
    }

    // .builder() 로 사용하기 위함
    public static Builder builder() {
        return new Builder();
    }

    public void update(UpdateRecommendRequest request) {
        this.recommendType = Objects.nonNull(request.getRecommendType()) ? request.getRecommendType() : this.recommendType;
        this.title = Objects.nonNull(request.getTitle()) ? request.getTitle() : this.title;
        this.contents = Objects.nonNull(request.getContents()) ? request.getContents() : this.contents;
        this.image = Objects.nonNull(request.getImage()) ? request.getImage() : this.image;
        this.modifiedDate = LocalDateTime.now();
    }
}


package com.example.toygry.entity;

public class Recommend {
    private final int id;
    private final String title;
    private final boolean content;

    // @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private Recommend(int id, String title, boolean content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }


    // @Builder
    public static class Builder {
        private int id;
        private String title;
        private boolean content;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder content(boolean content) {
            this.content = content;
            return this;
        }

        public Recommend build() {
            return new Recommend(id, title, content);
        }
    }

    // .builder() 로 사용하기 위함
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}


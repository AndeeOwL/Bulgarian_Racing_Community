package com.andreanbuhchev.bulgarian_racing_community.model.dto;

public class CommentCreationDto {
    private String username;
    private Long articleId;
    private String message;

    public CommentCreationDto(String username, Long articleId, String message) {
        this.username = username;
        this.articleId = articleId;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public CommentCreationDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getArticleId() {
        return articleId;
    }

    public CommentCreationDto setArticleId(Long articleId) {
        this.articleId = articleId;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommentCreationDto setMessage(String message) {
        this.message = message;
        return this;
    }
}

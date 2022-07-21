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

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.andreanbuhchev.bulgarian_racing_community.model.dto;

import javax.validation.constraints.NotBlank;

public class ArticleDto {

    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String text;

    public ArticleDto() {
    }

    public Long getId() {
        return id;
    }

    public ArticleDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public ArticleDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public ArticleDto setText(String text) {
        this.text = text;
        return this;
    }
}

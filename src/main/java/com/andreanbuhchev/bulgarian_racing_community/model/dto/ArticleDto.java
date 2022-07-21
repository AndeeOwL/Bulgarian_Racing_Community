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

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

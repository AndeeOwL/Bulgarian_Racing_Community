package com.andreanbuhchev.bulgarian_racing_community.model.dto;

import javax.validation.constraints.NotBlank;

public class ProductDto {

    @NotBlank
    private String name;

    private float price;

    @NotBlank
    private String description;

    @NotBlank
    private String photo;

    public ProductDto() {
    }

    public String getName() {
        return name;
    }

    public ProductDto setName(String name) {
        this.name = name;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public ProductDto setPrice(float price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public ProductDto setPhoto(String photo) {
        this.photo = photo;
        return this;
    }
}

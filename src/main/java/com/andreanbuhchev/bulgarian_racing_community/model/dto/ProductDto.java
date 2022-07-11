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

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

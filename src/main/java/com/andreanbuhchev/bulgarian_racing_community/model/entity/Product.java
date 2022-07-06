package com.andreanbuhchev.bulgarian_racing_community.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @ManyToOne
    private UserEntity userEntity;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private float price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    @Lob
    private String photo;

    public Product() {
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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

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

    public Product setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Product setPrice(float price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public Product setPhoto(String photo) {
        this.photo = photo;
        return this;
    }
}

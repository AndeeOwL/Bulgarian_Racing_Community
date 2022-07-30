package com.andreanbuhchev.bulgarian_racing_community.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event extends BaseEntity {

    @ManyToOne
    private UserEntity userEntity;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDate time;

    private float price;

    public Event() {
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public Event setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public String getName() {
        return name;
    }

    public Event setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Event setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Event setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getTime() {
        return time;
    }

    public Event setTime(LocalDate time) {
        this.time = time;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Event setPrice(float price) {
        this.price = price;
        return this;
    }
}

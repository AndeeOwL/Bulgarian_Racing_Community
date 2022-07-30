package com.andreanbuhchev.bulgarian_racing_community.model.entity;

import com.andreanbuhchev.bulgarian_racing_community.model.view.ShoppingCartView;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart extends BaseEntity {

    @ManyToOne
    private UserEntity userEntity;

    @ManyToMany
    private List<Event> events = new ArrayList<>();

    @ManyToMany
    private List<Product> products = new ArrayList<>();

    public ShoppingCart() {
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public ShoppingCart setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public List<Event> getEvents() {
        return events;
    }

    public ShoppingCart setEvents(List<Event> events) {
        this.events = events;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public ShoppingCart setProducts(List<Product> products) {
        this.products = products;
        return this;
    }
}

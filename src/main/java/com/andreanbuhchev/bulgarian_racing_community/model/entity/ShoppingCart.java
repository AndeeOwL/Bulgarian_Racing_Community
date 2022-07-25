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

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

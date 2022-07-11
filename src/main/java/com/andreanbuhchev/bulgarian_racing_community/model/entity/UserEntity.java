package com.andreanbuhchev.bulgarian_racing_community.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {


    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private boolean isActive;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userEntity")
    private List<Vehicle> vehicle;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserRoleEntity> role = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userEntity")
    private List<Article> articles;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userEntity")
    private List<Product> products;

    @OneToOne
    private ShoppingCart shoppingCart;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userEntity")
    private List<Event> events;

    public UserEntity() {
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(List<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public List<UserRoleEntity> getRole() {
        return role;
    }

    public void setRole(List<UserRoleEntity> role) {
        this.role = role;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }
}

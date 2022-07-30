package com.andreanbuhchev.bulgarian_racing_community.model.entity;

import javax.persistence.*;
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

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userEntity")
    private List<Vehicle> vehicle;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserRoleEntity> role = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userEntity")
    private List<Article> articles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userEntity")
    private List<Product> products = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userEntity")
    private List<Event> events = new ArrayList<>();

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    public UserEntity setVehicle(List<Vehicle> vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public List<UserRoleEntity> getRole() {
        return role;
    }

    public UserEntity setRole(List<UserRoleEntity> role) {
        this.role = role;
        return this;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public UserEntity setArticles(List<Article> articles) {
        this.articles = articles;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public UserEntity setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    public List<Event> getEvents() {
        return events;
    }

    public UserEntity setEvents(List<Event> events) {
        this.events = events;
        return this;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String fullRoles() {
        if (getRole().size() > 1) {
            return "USER,ADMIN";
        }
        return "USER";
    }

}

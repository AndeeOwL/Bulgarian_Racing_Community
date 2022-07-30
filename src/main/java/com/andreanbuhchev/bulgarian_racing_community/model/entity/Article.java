package com.andreanbuhchev.bulgarian_racing_community.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article extends BaseEntity {

    @ManyToOne
    private UserEntity userEntity;

    @Column(nullable = false)
    private String title;

    private String text;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "article")
    private List<Comment> comments;

    public Article() {
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public Article setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public Article setText(String text) {
        this.text = text;
        return this;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Article setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }
}

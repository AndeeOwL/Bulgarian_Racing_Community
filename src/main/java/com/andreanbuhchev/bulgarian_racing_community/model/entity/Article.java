package com.andreanbuhchev.bulgarian_racing_community.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Article() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

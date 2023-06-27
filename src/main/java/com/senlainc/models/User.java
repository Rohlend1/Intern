package com.senlainc.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public User(String username, List<Comment> comments, List<Review> reviews) {
        this.username = username;
        this.comments = comments;
        this.reviews = reviews;
    }
}

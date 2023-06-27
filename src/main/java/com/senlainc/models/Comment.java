package com.senlainc.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Comment")
@Data
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "owner",referencedColumnName = "user_id")
    private User owner;

    @OneToOne
    @JoinColumn(name = "reply",referencedColumnName = "comment_id")
    private Comment reply;

    @OneToOne
    @JoinColumn(name = "review",referencedColumnName = "review_id")
    private Review review;

    public Comment(String description, LocalDateTime createdAt, LocalDateTime updatedAt, User owner, Review review, Comment reply) {
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.owner = owner;
        this.review = review;
        this.reply = reply;
    }
}

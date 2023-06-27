package com.senlainc.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Review")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne()
    @JoinColumn(name = "owner",referencedColumnName = "user_id")
    private User owner;

    @OneToOne(mappedBy = "review",cascade = CascadeType.ALL)
    private Comment comment;


    public Review(String content, LocalDateTime createdAt, LocalDateTime updatedAt, User owner, Comment comment) {
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.owner = owner;
        this.comment = comment;
    }
}

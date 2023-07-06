package com.senlainc.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Comment")
@Data
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(optional = false, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "owner",referencedColumnName = "user_id")
    @ToString.Exclude
    private User owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_to",referencedColumnName = "comment_id")
    @EqualsAndHashCode.Exclude
    private Comment replyTo;

    @OneToMany(mappedBy = "replyTo", orphanRemoval = true, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Comment> replies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review",referencedColumnName = "review_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Review review;

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Comment(String description, LocalDateTime createdAt, LocalDateTime updatedAt, User owner, Review review, Comment replyTo) {
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.owner = owner;
        this.review = review;
        this.replyTo = replyTo;
    }
}

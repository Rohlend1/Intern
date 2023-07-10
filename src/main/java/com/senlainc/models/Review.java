package com.senlainc.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Review")
@Data
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer id;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(optional = false, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "owner",referencedColumnName = "user_id")
    @ToString.Exclude
    private User owner;

    @OneToMany(mappedBy = "review", cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    private List<Comment> comments;

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

    public Review(String content, LocalDateTime createdAt, LocalDateTime updatedAt, User owner) {
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.owner = owner;
    }
}

package com.senlainc.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Review {

    private int id;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private User user;

    private Comment comment;

    public Review() {
    }

    public Review(String content, LocalDateTime createdAt, LocalDateTime updatedAt, User user, Comment comment) {
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id && Objects.equals(content, review.content) && Objects.equals(createdAt, review.createdAt) && Objects.equals(updatedAt, review.updatedAt) && Objects.equals(user, review.user) && Objects.equals(comment, review.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, createdAt, updatedAt, user, comment);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", user=" + user +
                ", comment=" + comment +
                '}';
    }
}

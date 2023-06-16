package models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Comment {

    private int id;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private User owner;

    private Comment replies;

    private Review review;

    public Comment() {

    }

    public Comment(String description, LocalDateTime createdAt, LocalDateTime updatedAt, Comment replies, User owner, Review review) {
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.replies = replies;
        this.owner = owner;
        this.review = review;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Comment getReplies() {
        return replies;
    }

    public void setReplies(Comment replies) {
        this.replies = replies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id && Objects.equals(description, comment.description) && Objects.equals(createdAt, comment.createdAt) && Objects.equals(updatedAt, comment.updatedAt) && Objects.equals(owner, comment.owner) && Objects.equals(replies, comment.replies) && Objects.equals(review, comment.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, createdAt, updatedAt, owner, replies, review);
    }
}

package models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Comment {

    private int id;

    private String value;

    private LocalDateTime commentTime;

    public Comment() {

    }

    public Comment(String value, LocalDateTime commentTime) {
        this.value = value;
        this.commentTime = commentTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDateTime getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDateTime commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id && Objects.equals(value, comment.value) && Objects.equals(commentTime, comment.commentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, commentTime);
    }
}

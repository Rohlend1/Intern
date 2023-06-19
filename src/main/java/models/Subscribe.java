package models;

import java.util.Objects;

public class Subscribe {

    private int id;

    private User subscribedBy;

    private User subscribedAt;

    public Subscribe() {
    }

    public Subscribe(User subscribedTo, User subscribedAt) {
        this.subscribedBy = subscribedTo;
        this.subscribedAt = subscribedAt;
    }

    public User getSubscribedBy() {
        return subscribedBy;
    }

    public void setSubscribedBy(User subscribedBy) {
        this.subscribedBy = subscribedBy;
    }

    public User getSubscribedAt() {
        return subscribedAt;
    }

    public void setSubscribedAt(User subscribedAt) {
        this.subscribedAt = subscribedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscribe subscribe = (Subscribe) o;
        return id == subscribe.id && Objects.equals(subscribedBy, subscribe.subscribedBy) && Objects.equals(subscribedAt, subscribe.subscribedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subscribedBy, subscribedAt);
    }

    @Override
    public String toString() {
        return "Subscribe{" +
                "id=" + id +
                ", subscribedBy=" + subscribedBy +
                ", subscribedAt=" + subscribedAt +
                '}';
    }
}

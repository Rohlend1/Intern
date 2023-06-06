package entities;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Order {
    private static int counter;
    private int id;
    private LocalDateTime createdAt;
    private LocalDateTime willBeReadyBy;
    private String address;
    private boolean isExecuting;
    private boolean isClosed;
    private boolean isCancelled;
    private int spaceId;
    private int mechanicId;

    public Order(String address) {
        this.address = address;
        id = ++counter;
        createdAt = LocalDateTime.now();
        willBeReadyBy = createdAt.plus(2, ChronoUnit.HOURS);
        isClosed = false;
        isCancelled = false;
        isExecuting = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getWillBeReadyBy() {
        return willBeReadyBy;
    }

    public void setWillBeReadyBy(LocalDateTime willBeReadyBy) {
        this.willBeReadyBy = willBeReadyBy;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public int getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(int spaceId) {
        this.spaceId = spaceId;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Order.counter = counter;
    }

    public boolean isExecuting() {
        return isExecuting;
    }

    public void setExecuting(boolean executing) {
        isExecuting = executing;
    }

    public int getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(int mechanicId) {
        this.mechanicId = mechanicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (isExecuting != order.isExecuting) return false;
        if (isClosed != order.isClosed) return false;
        if (isCancelled != order.isCancelled) return false;
        if (spaceId != order.spaceId) return false;
        if (mechanicId != order.mechanicId) return false;
        if (!Objects.equals(createdAt, order.createdAt)) return false;
        if (!Objects.equals(willBeReadyBy, order.willBeReadyBy))
            return false;
        return Objects.equals(address, order.address);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (willBeReadyBy != null ? willBeReadyBy.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (isExecuting ? 1 : 0);
        result = 31 * result + (isClosed ? 1 : 0);
        result = 31 * result + (isCancelled ? 1 : 0);
        result = 31 * result + spaceId;
        result = 31 * result + mechanicId;
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", willBeReadyBy=" + willBeReadyBy +
                ", address='" + address + '\'' +
                ", isExecuting=" + isExecuting +
                ", isClosed=" + isClosed +
                ", isCancelled=" + isCancelled +
                ", spaceId=" + spaceId +
                ", mechanicId=" + mechanicId +
                '}';
    }
}

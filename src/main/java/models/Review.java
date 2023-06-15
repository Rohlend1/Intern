package models;

import java.util.Objects;

public class Review {

    private int id;

    private double value;

    public Review() {
    }

    public Review(double value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id && Double.compare(review.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}

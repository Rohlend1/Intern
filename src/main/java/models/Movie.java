package models;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Movie {

    private int id;

    private String name;

    private List<Actor> actors;

    private LocalDate dateOfShooting;

    private List<Review> reviews;

    private List<Comment> comments;

    public Movie() {
    }

    public Movie(String name, List<Actor> actors, LocalDate dateOfShooting, List<Review> reviews, List<Comment> comments) {
        this.name = name;
        this.actors = actors;
        this.dateOfShooting = dateOfShooting;
        this.reviews = reviews;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public LocalDate getDateOfShooting() {
        return dateOfShooting;
    }

    public void setDateOfShooting(LocalDate dateOfShooting) {
        this.dateOfShooting = dateOfShooting;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && Objects.equals(name, movie.name) && Objects.equals(actors, movie.actors) && Objects.equals(dateOfShooting, movie.dateOfShooting) && Objects.equals(reviews, movie.reviews) && Objects.equals(comments, movie.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, actors, dateOfShooting, reviews, comments);
    }
}

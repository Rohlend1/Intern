package models;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class Actor {

    private int id;

    private String name;

    private int height;

    private LocalDate birthDate;

    private List<Movie> movies;

    public Actor() {
    }

    public Actor(String name, int height, LocalDate birthDate, List<Movie> movies) {
        this.name = name;
        this.height = height;
        this.birthDate = birthDate;
        this.movies = movies;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return id == actor.id && height == actor.height && Objects.equals(name, actor.name) && Objects.equals(birthDate, actor.birthDate) && Objects.equals(movies, actor.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, height, birthDate, movies);
    }
}

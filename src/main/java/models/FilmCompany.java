package models;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class FilmCompany {

    private int id;

    private String name;

    private List<Movie> movies;

    private LocalDate dateOfFoundation;

    public FilmCompany() {
    }

    public FilmCompany(String name, List<Movie> movies, LocalDate dateOfFoundation) {
        this.name = name;
        this.movies = movies;
        this.dateOfFoundation = dateOfFoundation;
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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public LocalDate getDateOfFoundation() {
        return dateOfFoundation;
    }

    public void setDateOfFoundation(LocalDate dateOfFoundation) {
        this.dateOfFoundation = dateOfFoundation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCompany that = (FilmCompany) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(movies, that.movies) && Objects.equals(dateOfFoundation, that.dateOfFoundation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, movies, dateOfFoundation);
    }

    @Override
    public String toString() {
        return "FilmCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfFoundation=" + dateOfFoundation +
                '}';
    }
}

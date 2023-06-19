package models;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Movie {

    private int id;

    private String title;

    private List<Actor> actors;

    private LocalDate dateOfRelease;

    private FilmCompany filmCompany;

    private int duration;

    private int boxOffice;

    public Movie() {
    }

    public Movie(String title, List<Actor> actors, LocalDate dateOfRelease, FilmCompany filmCompany, int duration, int boxOffice) {
        this.title = title;
        this.actors = actors;
        this.dateOfRelease = dateOfRelease;
        this.filmCompany = filmCompany;
        this.duration = duration;
        this.boxOffice = boxOffice;
    }

    public FilmCompany getFilmCompany() {
        return filmCompany;
    }

    public void setFilmCompany(FilmCompany filmCompany) {
        this.filmCompany = filmCompany;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public LocalDate getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(LocalDate dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(int boxOffice) {
        this.boxOffice = boxOffice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && duration == movie.duration && boxOffice == movie.boxOffice && Objects.equals(title, movie.title) && Objects.equals(actors, movie.actors) && Objects.equals(dateOfRelease, movie.dateOfRelease) && Objects.equals(filmCompany, movie.filmCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, actors, dateOfRelease, filmCompany, duration, boxOffice);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", actors=" + actors +
                ", dateOfRelease=" + dateOfRelease +
                ", filmCompany=" + filmCompany +
                ", duration=" + duration +
                ", boxOffice=" + boxOffice +
                '}';
    }
}

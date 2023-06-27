package com.senlainc.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Movie")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;

    @Column(name = "date_of_release")
    private LocalDate dateOfRelease;

    @ManyToOne()
    @JoinColumn(name = "film_company",referencedColumnName = "company_id")
    private FilmCompany filmCompany;

    @Column(name = "duration")
    private int duration;

    @Column(name = "box_office")
    private int boxOffice;

    @ManyToMany(mappedBy = "movies")
    private List<Genre> genres;

    public Movie(String title, List<Actor> actors, LocalDate dateOfRelease, FilmCompany filmCompany, int duration, int boxOffice, List<Genre> genres) {
        this.title = title;
        this.actors = actors;
        this.dateOfRelease = dateOfRelease;
        this.filmCompany = filmCompany;
        this.duration = duration;
        this.boxOffice = boxOffice;
        this.genres = genres;
    }
}

package com.senlainc.dto.movies;

import com.senlainc.models.Actor;
import com.senlainc.models.FilmCompany;
import com.senlainc.models.Genre;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class MovieDTO {

    private String title;

    private List<Actor> actors;

    private LocalDate dateOfRelease;

    private FilmCompany filmCompany;

    private int duration;

    private double boxOffice;

    private List<Genre> genres;
}

package com.senlainc.dto.movies;

import com.senlainc.dto.actors.ActorDTO;
import com.senlainc.dto.filmcompanies.FilmCompanyDTO;
import com.senlainc.dto.genres.GenreDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter

public class MovieDTO {

    @NotBlank(message = "Title can't be empty")
    private String title;

    private List<ActorDTO> actors;

    @NotNull(message = "Release date can't be null")
    private LocalDate dateOfRelease;

    @NotNull(message = "Film company can't be null")
    private FilmCompanyDTO filmCompany;

    @Min(value = 1, message = "Duration can't be less than 1")
    private Integer duration;

    @Positive(message = "Box office can't be negative or equals zero")
    private Double boxOffice;

    private List<GenreDTO> genres;
}

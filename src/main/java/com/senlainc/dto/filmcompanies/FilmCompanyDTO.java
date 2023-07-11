package com.senlainc.dto.filmcompanies;

import com.senlainc.models.Movie;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class FilmCompanyDTO {

    private String name;

    private List<Movie> movies;

    private LocalDate dateOfFoundation;
}

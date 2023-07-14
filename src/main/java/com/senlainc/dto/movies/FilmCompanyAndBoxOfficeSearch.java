package com.senlainc.dto.movies;

import com.senlainc.dto.filmcompanies.FilmCompanyDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Setter
@Getter
public class FilmCompanyAndBoxOfficeSearch {

    @NotNull(message = "Film company can't be null")
    private FilmCompanyDTO filmCompanyDTO;

    @PositiveOrZero(message = "Millions can't be negative")
    private Double millions;
}

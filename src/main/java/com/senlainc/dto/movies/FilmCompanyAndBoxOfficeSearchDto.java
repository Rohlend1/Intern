package com.senlainc.dto.movies;

import com.senlainc.dto.filmcompanies.FilmCompanyDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Setter
@Getter
public class FilmCompanyAndBoxOfficeSearchDto {

    @NotNull(message = "Film company can't be null")
    private FilmCompanyDto filmCompanyDTO;

    @PositiveOrZero(message = "Millions can't be negative")
    private Double millions;
}

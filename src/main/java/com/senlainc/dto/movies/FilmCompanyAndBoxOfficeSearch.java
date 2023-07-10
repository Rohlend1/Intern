package com.senlainc.dto.movies;

import com.senlainc.dto.filmcompanies.FilmCompanyDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FilmCompanyAndBoxOfficeSearch {

    private FilmCompanyDTO filmCompanyDTO;

    private Double millions;
}

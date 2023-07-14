package com.senlainc.dto.filmcompanies;

import com.senlainc.dto.movies.MovieDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class FilmCompanyDTO {

    @Size(max = 100, message = "Film company name must be between 1 and 100 characters")
    @NotBlank(message = "Film company name can't be blank")
    private String name;

    private List<MovieDTO> movies;

    @NotNull(message = "Foundation date can't be null")
    @PastOrPresent(message = "Foundation date can't indicate a future time")
    private LocalDate dateOfFoundation;
}

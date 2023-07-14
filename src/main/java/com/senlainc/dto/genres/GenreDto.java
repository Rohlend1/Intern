package com.senlainc.dto.genres;

import com.senlainc.dto.movies.MovieDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
public class GenreDto {

    @Size(min = 3, max = 50, message = "Genre's name must be between 3 and 50 characters")
    private String name;

    private List<MovieDto> movies;
}

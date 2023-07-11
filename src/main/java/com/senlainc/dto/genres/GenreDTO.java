package com.senlainc.dto.genres;

import com.senlainc.models.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GenreDTO {

    private String name;

    private List<Movie> movies;
}

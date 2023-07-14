package com.senlainc.util.mappers;

import com.senlainc.dto.movies.MovieDto;
import com.senlainc.models.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDto toDTO(Movie Movie);
    Movie toEntity(MovieDto MovieDTO);
    List<Movie> toEntityList(List<MovieDto> movieDtos);
    List<MovieDto> toDTOList(List<Movie> Movie);
}

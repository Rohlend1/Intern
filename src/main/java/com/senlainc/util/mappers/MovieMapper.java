package com.senlainc.util.mappers;

import com.senlainc.dto.movies.MovieDTO;
import com.senlainc.models.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieDTO toDTO(Movie Movie);
    Movie toEntity(MovieDTO MovieDTO);
    List<Movie> toEntityList(List<MovieDTO> MovieDTOs);
    List<MovieDTO> toDTOList(List<Movie> Movie);
}

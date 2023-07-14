package com.senlainc.util.mappers;

import com.senlainc.dto.genres.GenreDto;
import com.senlainc.models.Genre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreDto toDTO(Genre Genre);
    Genre toEntity(GenreDto GenreDTO);
    List<Genre> toEntityList(List<GenreDto> genreDtos);
    List<GenreDto> toDTOList(List<Genre> Genre);
}

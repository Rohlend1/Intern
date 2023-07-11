package com.senlainc.util.mappers;

import com.senlainc.dto.genres.GenreDTO;
import com.senlainc.models.Genre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {
    GenreDTO toDTO(Genre Genre);
    Genre toEntity(GenreDTO GenreDTO);
    List<Genre> toEntityList(List<GenreDTO> GenreDTOs);
    List<GenreDTO> toDTOList(List<Genre> Genre);
}

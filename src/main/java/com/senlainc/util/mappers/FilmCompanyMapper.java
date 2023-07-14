package com.senlainc.util.mappers;

import com.senlainc.dto.filmcompanies.FilmCompanyDto;
import com.senlainc.models.FilmCompany;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilmCompanyMapper {
    FilmCompanyDto toDTO(FilmCompany FilmCompany);
    FilmCompany toEntity(FilmCompanyDto FilmCompanyDTO);
    List<FilmCompany> toEntityList(List<FilmCompanyDto> filmCompanyDtos);
    List<FilmCompanyDto> toDTOList(List<FilmCompany> FilmCompany);
}

package com.senlainc.util.mappers;

import com.senlainc.dto.filmcompanies.FilmCompanyDTO;
import com.senlainc.models.FilmCompany;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FilmCompanyMapper {
    FilmCompanyDTO toDTO(FilmCompany FilmCompany);
    FilmCompany toEntity(FilmCompanyDTO FilmCompanyDTO);
    List<FilmCompany> toEntityList(List<FilmCompanyDTO> FilmCompanyDTOs);
    List<FilmCompanyDTO> toDTOList(List<FilmCompany> FilmCompany);
}

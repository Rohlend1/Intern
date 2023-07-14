package com.senlainc.services;

import com.senlainc.dto.filmcompanies.FilmCompanyDTO;
import com.senlainc.models.FilmCompany;

import java.util.List;

public interface FilmCompanyService {

    List<FilmCompanyDTO> findAll();

    FilmCompanyDTO findById(int id);

    void saveOrUpdate(FilmCompanyDTO filmCompany);

    void delete(FilmCompanyDTO filmCompany);

    void delete(int id);

    FilmCompanyDTO findByName(String name);

    List<FilmCompanyDTO> findByDateOfFoundationLessThan(int year);

    List<FilmCompanyDTO> findAllSortByName();

    List<FilmCompanyDTO> findByNameWithTwoWordsAndDateOfFoundationBetween(int year1, int year2);

    FilmCompanyDTO findLeastPopularFilmCompany();
}

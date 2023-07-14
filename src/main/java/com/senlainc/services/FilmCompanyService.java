package com.senlainc.services;

import com.senlainc.dto.filmcompanies.FilmCompanyDto;

import java.util.List;

public interface FilmCompanyService {

    List<FilmCompanyDto> findAll();

    FilmCompanyDto findById(int id);

    void saveOrUpdate(FilmCompanyDto filmCompany);

    void delete(FilmCompanyDto filmCompany);

    void delete(int id);

    FilmCompanyDto findByName(String name);

    List<FilmCompanyDto> findByDateOfFoundationLessThan(int year);

    List<FilmCompanyDto> findAllSortByName();

    List<FilmCompanyDto> findByNameWithTwoWordsAndDateOfFoundationBetween(int year1, int year2);

    FilmCompanyDto findLeastPopularFilmCompany();
}

package com.senlainc.services;

import com.senlainc.models.FilmCompany;

import java.util.List;

public interface FilmCompanyService {

    List<FilmCompany> findAll();

    FilmCompany findById(int id);

    void saveOrUpdate(FilmCompany filmCompany);

    void delete(FilmCompany filmCompany);

    FilmCompany findByName(String name);

    List<FilmCompany> findByDateOfFoundationLessThan(int year);

    List<FilmCompany> findAllSortByName();

    List<FilmCompany> findByNameWithTwoWordsAndDateOfFoundationBetween(int year1, int year2);

    FilmCompany findLeastPopularFilmCompany();
}

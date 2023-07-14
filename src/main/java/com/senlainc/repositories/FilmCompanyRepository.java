package com.senlainc.repositories;

import com.senlainc.models.FilmCompany;

import java.util.List;

public interface FilmCompanyRepository {

    List<FilmCompany> findAll();

    void saveOrUpdate(FilmCompany filmCompany);

    FilmCompany findById(int id);

    void delete(FilmCompany filmCompany);

    void delete(int id);

    FilmCompany findByName(String name);

    List<FilmCompany> findByDateOfFoundationLessThan(int year);

    List<FilmCompany> findAllSortByName();

    List<FilmCompany> findByNameWithTwoWordsAndDateOfFoundationBetween(int year1, int year2);

    FilmCompany findLeastPopularFilmCompany();
}

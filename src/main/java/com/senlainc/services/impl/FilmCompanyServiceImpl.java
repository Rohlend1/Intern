package com.senlainc.services.impl;

import com.senlainc.models.FilmCompany;
import com.senlainc.repositories.FilmCompanyRepository;
import com.senlainc.services.FilmCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmCompanyServiceImpl implements FilmCompanyService {

    private final FilmCompanyRepository filmCompanyRepository;

    @Autowired
    public FilmCompanyServiceImpl(FilmCompanyRepository filmCompanyRepository) {
        this.filmCompanyRepository = filmCompanyRepository;
    }

    public List<FilmCompany> findAll(){
        return filmCompanyRepository.findAll();
    }

    public FilmCompany findById(int id){
        return filmCompanyRepository.findById(id);
    }

    public void saveOrUpdate(FilmCompany filmCompany){
        filmCompanyRepository.saveOrUpdate(filmCompany);
    }

    public void delete(FilmCompany filmCompany){
        filmCompanyRepository.delete(filmCompany);
    }

    public FilmCompany findByName(String name){
        return filmCompanyRepository.findByName(name);
    }

    public List<FilmCompany> findByDateOfFoundationLessThan(int year){
        return filmCompanyRepository.findByDateOfFoundationLessThan(year);
    }

    public List<FilmCompany> findAllSortByName() {
        return filmCompanyRepository.findAllSortByName();
    }

    public List<FilmCompany> findByNameWithTwoWordsAndDateOfFoundationBetween(int year1, int year2){
        return filmCompanyRepository.findByNameWithTwoWordsAndDateOfFoundationBetween(year1,year2);
    }

    public FilmCompany findLeastPopularFilmCompany(){
        return filmCompanyRepository.findLeastPopularFilmCompany();
    }
}

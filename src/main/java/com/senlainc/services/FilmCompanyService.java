package com.senlainc.services;

import com.senlainc.models.FilmCompany;
import com.senlainc.repositories.FilmCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmCompanyService {

    private final FilmCompanyRepository filmCompanyRepository;

    @Autowired
    public FilmCompanyService(FilmCompanyRepository filmCompanyRepository) {
        this.filmCompanyRepository = filmCompanyRepository;
    }

    public List<FilmCompany> findAll(){
        return filmCompanyRepository.findAll();
    }

    public FilmCompany findById(int id){
        return filmCompanyRepository.findById(id);
    }

    public void save(FilmCompany filmCompany){
        if(filmCompany.getId() != null){
            update(filmCompany.getId(),filmCompany);
        }
        else {
            filmCompanyRepository.save(filmCompany);
        }
    }

    public void delete(FilmCompany filmCompany){
        filmCompanyRepository.delete(filmCompany);
    }

    public void update(int id, FilmCompany filmCompany){
        filmCompany.setId(id);
        filmCompanyRepository.update(filmCompany);
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

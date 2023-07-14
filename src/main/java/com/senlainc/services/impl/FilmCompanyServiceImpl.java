package com.senlainc.services.impl;

import com.senlainc.dto.filmcompanies.FilmCompanyDto;
import com.senlainc.repositories.FilmCompanyRepository;
import com.senlainc.services.FilmCompanyService;
import com.senlainc.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmCompanyServiceImpl implements FilmCompanyService {

    private final FilmCompanyRepository filmCompanyRepository;

    private final Converter converter;

    @Autowired
    public FilmCompanyServiceImpl(FilmCompanyRepository filmCompanyRepository, Converter converter) {
        this.filmCompanyRepository = filmCompanyRepository;
        this.converter = converter;
    }

    public List<FilmCompanyDto> findAll(){
        return converter.convertListToFilmCompanyDTO(filmCompanyRepository.findAll());
    }

    public FilmCompanyDto findById(int id){
        return converter.convertToFilmCompanyDTO(filmCompanyRepository.findById(id));
    }

    public void saveOrUpdate(FilmCompanyDto filmCompanyDTO){
        filmCompanyRepository.saveOrUpdate(converter.convertToFilmCompany(filmCompanyDTO));
    }

    public void delete(FilmCompanyDto filmCompanyDTO){
        filmCompanyRepository.delete(converter.convertToFilmCompany(filmCompanyDTO));
    }

    public void delete(int id) {
        filmCompanyRepository.delete(id);
    }

    public FilmCompanyDto findByName(String name){
        return converter.convertToFilmCompanyDTO(filmCompanyRepository.findByName(name));
    }

    public List<FilmCompanyDto> findByDateOfFoundationLessThan(int year){
        return converter.convertListToFilmCompanyDTO(filmCompanyRepository.findByDateOfFoundationLessThan(year));
    }

    public List<FilmCompanyDto> findAllSortByName() {
        return converter.convertListToFilmCompanyDTO(filmCompanyRepository.findAllSortByName());
    }

    public List<FilmCompanyDto> findByNameWithTwoWordsAndDateOfFoundationBetween(int year1, int year2){
        return converter.convertListToFilmCompanyDTO(filmCompanyRepository.findByNameWithTwoWordsAndDateOfFoundationBetween(year1,year2));
    }

    public FilmCompanyDto findLeastPopularFilmCompany(){
        return converter.convertToFilmCompanyDTO(filmCompanyRepository.findLeastPopularFilmCompany());
    }
}

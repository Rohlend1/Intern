package com.senlainc.services.impl;

import com.senlainc.dto.filmcompanies.FilmCompanyDTO;
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

    public List<FilmCompanyDTO> findAll(){
        return converter.convertListToFilmCompanyDTO(filmCompanyRepository.findAll());
    }

    public FilmCompanyDTO findById(int id){
        return converter.convertToFilmCompanyDTO(filmCompanyRepository.findById(id));
    }

    public void saveOrUpdate(FilmCompanyDTO filmCompanyDTO){
        filmCompanyRepository.saveOrUpdate(converter.convertToFilmCompany(filmCompanyDTO));
    }

    public void delete(FilmCompanyDTO filmCompanyDTO){
        filmCompanyRepository.delete(converter.convertToFilmCompany(filmCompanyDTO));
    }

    public void delete(int id) {
        filmCompanyRepository.delete(id);
    }

    public FilmCompanyDTO findByName(String name){
        return converter.convertToFilmCompanyDTO(filmCompanyRepository.findByName(name));
    }

    public List<FilmCompanyDTO> findByDateOfFoundationLessThan(int year){
        return converter.convertListToFilmCompanyDTO(filmCompanyRepository.findByDateOfFoundationLessThan(year));
    }

    public List<FilmCompanyDTO> findAllSortByName() {
        return converter.convertListToFilmCompanyDTO(filmCompanyRepository.findAllSortByName());
    }

    public List<FilmCompanyDTO> findByNameWithTwoWordsAndDateOfFoundationBetween(int year1, int year2){
        return converter.convertListToFilmCompanyDTO(filmCompanyRepository.findByNameWithTwoWordsAndDateOfFoundationBetween(year1,year2));
    }

    public FilmCompanyDTO findLeastPopularFilmCompany(){
        return converter.convertToFilmCompanyDTO(filmCompanyRepository.findLeastPopularFilmCompany());
    }
}

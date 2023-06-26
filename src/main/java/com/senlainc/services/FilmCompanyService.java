package com.senlainc.services;

import com.senlainc.models.FilmCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senlainc.repositories.FilmCompanyRepository;

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
        filmCompanyRepository.save(filmCompany);
    }

    public void delete(FilmCompany filmCompany){
        filmCompanyRepository.delete(filmCompany);
    }

    public void update(int id, FilmCompany filmCompany){
        filmCompanyRepository.delete(filmCompanyRepository.findById(id));
        filmCompany.setId(id);
        filmCompanyRepository.save(filmCompany);
    }
}

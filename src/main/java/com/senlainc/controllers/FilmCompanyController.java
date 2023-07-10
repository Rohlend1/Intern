package com.senlainc.controllers;

import com.senlainc.dto.filmcompanies.FilmCompanyDTO;
import com.senlainc.dto.DateBetweenSearchDTO;
import com.senlainc.errors.ModelNotFoundException;
import com.senlainc.models.FilmCompany;
import com.senlainc.services.FilmCompanyService;
import com.senlainc.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film_companies")
public class FilmCompanyController {

    @Autowired
    private FilmCompanyService filmCompanyService;

    @GetMapping
    public List<FilmCompanyDTO> getFilmCompanies(){
        return Converter.convertListToFilmCompanyDTO(filmCompanyService.findAll());
    }

    @GetMapping("/{id}")
    public FilmCompanyDTO getFilmCompany(@PathVariable("id") int id){
        return Converter.convertToFilmCompanyDTO(filmCompanyService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteFilmCompany(@PathVariable("id") int id){
        try{
            FilmCompany filmCompany = filmCompanyService.findById(id);
            filmCompanyService.delete(filmCompany);
        }
        catch (ModelNotFoundException e){
            System.out.println("No film company with this id was found");
        }
    }

    @PatchMapping
    public void updateFilmCompany(FilmCompanyDTO filmCompanyDTO){
        filmCompanyService.saveOrUpdate(Converter.convertToFilmCompany(filmCompanyDTO));
    }

    @PostMapping
    public void createFilmCompany(FilmCompanyDTO filmCompanyDTO){
        filmCompanyService.saveOrUpdate(Converter.convertToFilmCompany(filmCompanyDTO));
    }

    @GetMapping("/date_foundation")
    public List<FilmCompanyDTO> getFilmCompanyByDateOfFoundationLessThan(@RequestParam("years") Integer years){
        return Converter.convertListToFilmCompanyDTO(filmCompanyService.findByDateOfFoundationLessThan(years));
    }

    @GetMapping("/name_sorted")
    public List<FilmCompanyDTO> getFilmCompaniesSortByName(){
        return Converter.convertListToFilmCompanyDTO(filmCompanyService.findAllSortByName());
    }

    @GetMapping("/least_popular")
    public FilmCompanyDTO getLeastPopularFilmCompany(){
        return Converter.convertToFilmCompanyDTO(filmCompanyService.findLeastPopularFilmCompany());
    }

    @GetMapping("/name")
    public FilmCompanyDTO getFilmCompanyByName(@RequestParam("name") String name){
        return Converter.convertToFilmCompanyDTO(filmCompanyService.findByName(name));
    }

    @GetMapping("/date_between")
    public List<FilmCompanyDTO> getFilmCompanyByNameWithTwoWordsAndDateOfFoundationBetween(@RequestBody DateBetweenSearchDTO dto){
        return Converter.convertListToFilmCompanyDTO(filmCompanyService.findByNameWithTwoWordsAndDateOfFoundationBetween(dto.getYear1(), dto.getYear2()));
    }
}

package com.senlainc.controllers;

import com.senlainc.dto.filmcompanies.FilmCompanyDTO;
import com.senlainc.dto.DateBetweenSearchDTO;
import com.senlainc.services.FilmCompanyService;
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
        return filmCompanyService.findAll();
    }

    @GetMapping("/{id}")
    public FilmCompanyDTO getFilmCompany(@PathVariable("id") int id){
        return filmCompanyService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFilmCompany(@PathVariable("id") int id){
        filmCompanyService.delete(id);
    }

    @PatchMapping
    public void updateFilmCompany(@RequestBody FilmCompanyDTO filmCompanyDTO){
        filmCompanyService.saveOrUpdate(filmCompanyDTO);
    }

    @PostMapping
    public void createFilmCompany(@RequestBody FilmCompanyDTO filmCompanyDTO){
        filmCompanyService.saveOrUpdate(filmCompanyDTO);
    }

    @GetMapping("/date_foundation")
    public List<FilmCompanyDTO> getFilmCompanyByDateOfFoundationLessThan(@RequestParam("years") Integer years){
        return filmCompanyService.findByDateOfFoundationLessThan(years);
    }

    @GetMapping("/name_sorted")
    public List<FilmCompanyDTO> getFilmCompaniesSortByName(){
        return filmCompanyService.findAllSortByName();
    }

    @GetMapping("/least_popular")
    public FilmCompanyDTO getLeastPopularFilmCompany(){
        return filmCompanyService.findLeastPopularFilmCompany();
    }

    @GetMapping("/name")
    public FilmCompanyDTO getFilmCompanyByName(@RequestParam("name") String name){
        return filmCompanyService.findByName(name);
    }

    @GetMapping("/date_between")
    public List<FilmCompanyDTO> getFilmCompanyByNameWithTwoWordsAndDateOfFoundationBetween(@RequestBody DateBetweenSearchDTO dto){
        return filmCompanyService.findByNameWithTwoWordsAndDateOfFoundationBetween(dto.getYear1(), dto.getYear2());
    }
}

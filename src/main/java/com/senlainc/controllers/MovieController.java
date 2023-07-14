package com.senlainc.controllers;

import com.senlainc.dto.DateBetweenSearchDTO;
import com.senlainc.dto.PaginationSearch;
import com.senlainc.dto.movies.FilmCompanyAndBoxOfficeSearch;
import com.senlainc.dto.movies.MovieDTO;
import com.senlainc.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<MovieDTO> getMovies(){
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public MovieDTO getMovie(@PathVariable("id") int id){
        return movieService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") int id){
        movieService.delete(id);
    }

    @PatchMapping
    public void updateMovie(@RequestBody MovieDTO movieDTO){
        movieService.saveOrUpdate(movieDTO);
    }

    @PostMapping
    public void createMovie(@RequestBody MovieDTO movieDTO){
        movieService.saveOrUpdate(movieDTO);
    }

    @GetMapping("/date_between")
    public List<MovieDTO> getMovieByDateOfReleaseBetween(@RequestBody DateBetweenSearchDTO dto){
        return movieService.findByDateOfReleaseBetween(dto.getYear1(), dto.getYear2());
    }

    @GetMapping("/actors")
    public List<MovieDTO> getMoviesByActorsLessThan(@RequestParam("amount") Long amount){
        return movieService.findByActorsLessThan(amount);
    }

    @GetMapping("/film_company_box_office")
    public List<MovieDTO> getMoviesByFilmCompanyEqualsAndBoxOfficeGreaterThan(@RequestBody FilmCompanyAndBoxOfficeSearch dto){
        return movieService.findByFilmCompanyEqualsAndBoxOfficeGreaterThan(dto.getFilmCompanyDTO(), dto.getMillions());
    }

    @GetMapping("/pagination")
    public List<MovieDTO> getMoviesPagination(@RequestBody PaginationSearch dto){
        return movieService.findAllPagination(dto.getPage(), dto.getItemsPerPage());
    }
}

package com.senlainc.controllers;

import com.senlainc.dto.DateBetweenSearchDTO;
import com.senlainc.dto.PaginationSearch;
import com.senlainc.dto.movies.FilmCompanyAndBoxOfficeSearch;
import com.senlainc.dto.movies.MovieDTO;
import com.senlainc.errors.ModelNotFoundException;
import com.senlainc.models.FilmCompany;
import com.senlainc.models.Movie;
import com.senlainc.services.MovieService;
import com.senlainc.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private Converter converter;

    @GetMapping
    public List<MovieDTO> getMovies(){
        return converter.convertListToMovieDTO(movieService.findAll());
    }

    @GetMapping("/{id}")
    public MovieDTO getMovie(@PathVariable("id") int id){
        return converter.convertToMovieDTO(movieService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") int id){
        try{
            Movie movie = movieService.findById(id);
            movieService.delete(movie);
        }
        catch (ModelNotFoundException e){
            System.out.println("No genre with this id was found");
        }
    }

    @PatchMapping
    public void updateMovie(@RequestBody MovieDTO movieDTO){
        movieService.saveOrUpdate(converter.convertToMovie(movieDTO));
    }

    @PostMapping
    public void createMovie(@RequestBody MovieDTO movieDTO){
        movieService.saveOrUpdate(converter.convertToMovie(movieDTO));
    }

    @GetMapping("/date_between")
    public List<MovieDTO> getMovieByDateOfReleaseBetween(@RequestBody DateBetweenSearchDTO dto){
        return converter.convertListToMovieDTO(movieService.findByDateOfReleaseBetween(dto.getYear1(), dto.getYear2()));
    }

    @GetMapping("/actors")
    public List<MovieDTO> getMoviesByActorsLessThan(@RequestParam("amount") Long amount){
        return converter.convertListToMovieDTO(movieService.findByActorsLessThan(amount));
    }

    @GetMapping("/film_company_box_office")
    public List<MovieDTO> getMoviesByFilmCompanyEqualsAndBoxOfficeGreaterThan(@RequestBody FilmCompanyAndBoxOfficeSearch dto){
        FilmCompany filmCompany = converter.convertToFilmCompany(dto.getFilmCompanyDTO());
        return converter.convertListToMovieDTO(movieService.findByFilmCompanyEqualsAndBoxOfficeGreaterThan(filmCompany, dto.getMillions()));
    }

    @GetMapping("/pagination")
    public List<MovieDTO> getMoviesPagination(@RequestBody PaginationSearch dto){
        return converter.convertListToMovieDTO(movieService.findAllPagination(dto.getPage(), dto.getItemsPerPage()));
    }
}

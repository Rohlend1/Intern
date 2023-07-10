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

    @GetMapping
    public List<MovieDTO> getMovies(){
        return Converter.convertListToMovieDTO(movieService.findAll());
    }

    @GetMapping("/{id}")
    public MovieDTO getMovie(@PathVariable("id") int id){
        return Converter.convertToMovieDTO(movieService.findById(id));
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
    public void updateMovie(MovieDTO movieDTO){
        movieService.saveOrUpdate(Converter.convertToMovie(movieDTO));
    }

    @PostMapping
    public void createMovie(MovieDTO movieDTO){
        movieService.saveOrUpdate(Converter.convertToMovie(movieDTO));
    }

    @GetMapping("/date_between")
    public List<MovieDTO> getMovieByDateOfReleaseBetween(@RequestBody DateBetweenSearchDTO dto){
        return Converter.convertListToMovieDTO(movieService.findByDateOfReleaseBetween(dto.getYear1(), dto.getYear2()));
    }

    @GetMapping("/actors")
    public List<MovieDTO> getMoviesByActorsLessThan(@RequestParam("amount") Long amount){
        return Converter.convertListToMovieDTO(movieService.findByActorsLessThan(amount));
    }

    @GetMapping("/film_company_box_office")
    public List<MovieDTO> getMoviesByFilmCompanyEqualsAndBoxOfficeGreaterThan(@RequestBody FilmCompanyAndBoxOfficeSearch dto){
        FilmCompany filmCompany = Converter.convertToFilmCompany(dto.getFilmCompanyDTO());
        return Converter.convertListToMovieDTO(movieService.findByFilmCompanyEqualsAndBoxOfficeGreaterThan(filmCompany, dto.getMillions()));
    }

    @GetMapping("/pagination")
    public List<MovieDTO> getMoviesPagination(@RequestBody PaginationSearch dto){
        return Converter.convertListToMovieDTO(movieService.findAllPagination(dto.getPage(), dto.getItemsPerPage()));
    }
}

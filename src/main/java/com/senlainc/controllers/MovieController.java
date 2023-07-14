package com.senlainc.controllers;

import com.senlainc.dto.DateBetweenSearchDto;
import com.senlainc.dto.PaginationDto;
import com.senlainc.dto.movies.FilmCompanyAndBoxOfficeSearchDto;
import com.senlainc.dto.movies.MovieDto;
import com.senlainc.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public List<MovieDto> getMovies(){
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public MovieDto getMovie(@PathVariable("id") int id){
        return movieService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") int id){
        movieService.delete(id);
    }

    @PutMapping
    public void saveOrUpdateMovie(@RequestBody MovieDto movieDTO){
        movieService.saveOrUpdate(movieDTO);
    }

    @GetMapping("/find/release-date/between")
    public List<MovieDto> getMovieByDateOfReleaseBetween(@RequestBody DateBetweenSearchDto dto){
        return movieService.findByDateOfReleaseBetween(dto.getYear1(), dto.getYear2());
    }

    @GetMapping("/find/actors")
    public List<MovieDto> getMoviesByActorsLessThan(@RequestParam("amount") Long amount){
        return movieService.findByActorsLessThan(amount);
    }

    @GetMapping("/find/film-company/box-office")
    public List<MovieDto> getMoviesByFilmCompanyEqualsAndBoxOfficeGreaterThan(@RequestBody FilmCompanyAndBoxOfficeSearchDto dto){
        return movieService.findByFilmCompanyEqualsAndBoxOfficeGreaterThan(dto.getFilmCompanyDTO(), dto.getMillions());
    }

    @GetMapping("/find/page")
    public List<MovieDto> getPaginatedMovies(@RequestBody PaginationDto dto){
        return movieService.findWithPagination(dto.getPage(), dto.getItemsPerPage());
    }
}

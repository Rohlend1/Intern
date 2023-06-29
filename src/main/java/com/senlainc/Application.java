package com.senlainc;

import com.senlainc.config.SpringConfig;
import com.senlainc.services.FilmCompanyService;
import com.senlainc.services.GenreService;
import com.senlainc.services.MovieService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        FilmCompanyService filmCompanyService = context.getBean(FilmCompanyService.class);

        GenreService genreService = context.getBean(GenreService.class);

        MovieService movieService = context.getBean(MovieService.class);

        System.out.println(movieService.findDateOfReleaseBetween(2021,2022));

        System.out.println(movieService.findFilmCompanyEqualsAndBoxOfficeGreaterThan(filmCompanyService.findByName("WB"),1.5));

        System.out.println(movieService.findActorsLowerThan(4));

        System.out.println(movieService.findAllPagination(0,10));

        System.out.println(genreService.findGenreLike('a'));

        System.out.println(genreService.findMoviesGreaterThanAndMoviesDurationGreaterThan(1,70));

        System.out.println(genreService.findMostPopularGenre());
    }
}

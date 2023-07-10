package com.senlainc.util;

import com.senlainc.dto.actors.ActorDTO;
import com.senlainc.dto.comments.CommentDTO;
import com.senlainc.dto.filmcompanies.FilmCompanyDTO;
import com.senlainc.dto.genres.GenreDTO;
import com.senlainc.dto.movies.MovieDTO;
import com.senlainc.dto.reviews.ReviewDTO;
import com.senlainc.dto.subscribes.SubscribeDTO;
import com.senlainc.dto.users.UserDTO;
import com.senlainc.models.*;

import java.util.List;

public class Converter {

    public static ActorDTO convertToActorDTO(Actor actor){
        return null;
    }

    public static Actor convertToActor(ActorDTO actorDTO){
        return null;
    }

    public static List<ActorDTO> convertListToActorDTO(List<Actor> actors){
        return actors.stream().map(Converter::convertToActorDTO).toList();
    }

    public static List<Actor> convertListToActor(List<ActorDTO> actorsDTOs){
        return actorsDTOs.stream().map(Converter::convertToActor).toList();
    }

    public static CommentDTO convertToCommentDTO(Comment comment){
        return null;
    }

    public static Comment convertToComment(CommentDTO commentDTO){
        return null;
    }

    public static List<CommentDTO> convertListToCommentDTO(List<Comment> comments){
        return comments.stream().map(Converter::convertToCommentDTO).toList();
    }

    public static List<Comment> convertListToComment(List<CommentDTO> commentDTOs){
        return commentDTOs.stream().map(Converter::convertToComment).toList();
    }

    public static FilmCompanyDTO convertToFilmCompanyDTO(FilmCompany filmCompany){
        return null;
    }

    public static FilmCompany convertToFilmCompany(FilmCompanyDTO filmCompanyDTO){
        return null;
    }

    public static List<FilmCompanyDTO> convertListToFilmCompanyDTO(List<FilmCompany> filmCompanies){
        return filmCompanies.stream().map(Converter::convertToFilmCompanyDTO).toList();
    }

    public static List<FilmCompany> convertListToFilmCompany(List<FilmCompanyDTO> filmCompanyDTOs){
        return filmCompanyDTOs.stream().map(Converter::convertToFilmCompany).toList();
    }

    public static ReviewDTO convertToReviewDTO(Review review){
        return null;
    }

    public static Review convertToReview(ReviewDTO reviewDTO){
        return null;
    }

    public static List<ReviewDTO> convertListToReviewDTO(List<Review> reviews){
        return reviews.stream().map(Converter::convertToReviewDTO).toList();
    }

    public static List<Review> convertListToReview(List<ReviewDTO> reviewDTOs){
        return reviewDTOs.stream().map(Converter::convertToReview).toList();
    }

    public static GenreDTO convertToGenreDTO(Genre genre){
        return null;
    }

    public static Genre convertToGenre(GenreDTO genreDTO){
        return null;
    }

    public static List<GenreDTO> convertListToGenreDTO(List<Genre> genres){
        return genres.stream().map(Converter::convertToGenreDTO).toList();
    }

    public static List<Genre> convertListToGenre(List<GenreDTO> genreDTOs){
        return genreDTOs.stream().map(Converter::convertToGenre).toList();
    }

    public static MovieDTO convertToMovieDTO(Movie movie){
        return null;
    }

    public static Movie convertToMovie(MovieDTO movieDTO){
        return null;
    }

    public static List<MovieDTO> convertListToMovieDTO(List<Movie> movies){
        return movies.stream().map(Converter::convertToMovieDTO).toList();
    }

    public static List<Movie> convertListToMovie(List<MovieDTO> movieDTOs){
        return movieDTOs.stream().map(Converter::convertToMovie).toList();
    }

    public static SubscribeDTO convertToSubscribeDTO(Subscribe subscribe){
        return null;
    }

    public static Subscribe convertToSubscribe(SubscribeDTO subscribeDTOs){
        return null;
    }

    public static List<SubscribeDTO> convertListToSubscribeDTO(List<Subscribe> subscribes){
        return subscribes.stream().map(Converter::convertToSubscribeDTO).toList();
    }

    public static List<Subscribe> convertListToSubscribe(List<SubscribeDTO> subscribeDTOs){
        return subscribeDTOs.stream().map(Converter::convertToSubscribe).toList();
    }

    public static UserDTO convertToUserDTO(User user){
        return null;
    }

    public static User convertToUser(UserDTO userDTO){
        return null;
    }

    public static List<UserDTO> convertListToUserDTO(List<User> users){
        return users.stream().map(Converter::convertToUserDTO).toList();
    }

    public static List<User> convertListToUser(List<UserDTO> userDTOs){
        return userDTOs.stream().map(Converter::convertToUser).toList();
    }
}

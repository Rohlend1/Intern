package com.senlainc.util;

import com.senlainc.dto.actors.ActorDto;
import com.senlainc.dto.comments.CommentDto;
import com.senlainc.dto.filmcompanies.FilmCompanyDto;
import com.senlainc.dto.genres.GenreDto;
import com.senlainc.dto.movies.MovieDto;
import com.senlainc.dto.reviews.ReviewDto;
import com.senlainc.dto.subscribes.SubscribeDto;
import com.senlainc.dto.users.UserDto;
import com.senlainc.models.*;
import com.senlainc.util.mappers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Converter {

    private final ActorMapper actorMapper;

    private final CommentMapper commentMapper;

    private final GenreMapper genreMapper;

    private final FilmCompanyMapper filmCompanyMapper;

    private final MovieMapper movieMapper;

    private final ReviewMapper reviewMapper;

    private final UserMapper userMapper;

    private final SubscribeMapper subscribeMapper;

    @Autowired
    public Converter(ActorMapper actorMapper, CommentMapper commentMapper, GenreMapper genreMapper, FilmCompanyMapper filmCompanyMapper, MovieMapper movieMapper, ReviewMapper reviewMapper, UserMapper userMapper, SubscribeMapper subscribeMapper) {
        this.actorMapper = actorMapper;
        this.commentMapper = commentMapper;
        this.genreMapper = genreMapper;
        this.filmCompanyMapper = filmCompanyMapper;
        this.movieMapper = movieMapper;
        this.reviewMapper = reviewMapper;
        this.userMapper = userMapper;
        this.subscribeMapper = subscribeMapper;
    }

    public ActorDto convertToActorDTO(Actor actor){
        return actorMapper.toDTO(actor);
    }

    public Actor convertToActor(ActorDto actorDTO){
        return actorMapper.toEntity(actorDTO);
    }

    public List<ActorDto> convertListToActorDTO(List<Actor> actors){
        return actorMapper.toDTOList(actors);
    }

    public List<Actor> convertListToActor(List<ActorDto> actorsDTOs){
        return actorMapper.toEntityList(actorsDTOs);
    }

    public CommentDto convertToCommentDTO(Comment comment){
        return commentMapper.toDTO(comment);
    }

    public Comment convertToComment(CommentDto commentDTO){
        return commentMapper.toEntity(commentDTO);
    }

    public List<CommentDto> convertListToCommentDTO(List<Comment> comments){
        return commentMapper.toDTOList(comments);
    }

    public List<Comment> convertListToComment(List<CommentDto> commentDtos){
        return commentMapper.toEntityList(commentDtos);
    }

    public FilmCompanyDto convertToFilmCompanyDTO(FilmCompany filmCompany){
        return filmCompanyMapper.toDTO(filmCompany);
    }

    public FilmCompany convertToFilmCompany(FilmCompanyDto filmCompanyDTO){
        return filmCompanyMapper.toEntity(filmCompanyDTO);
    }

    public List<FilmCompanyDto> convertListToFilmCompanyDTO(List<FilmCompany> filmCompanies){
        return filmCompanyMapper.toDTOList(filmCompanies);
    }

    public List<FilmCompany> convertListToFilmCompany(List<FilmCompanyDto> filmCompanyDtos){
        return filmCompanyMapper.toEntityList(filmCompanyDtos);
    }

    public ReviewDto convertToReviewDTO(Review review){
        return reviewMapper.toDTO(review);
    }

    public Review convertToReview(ReviewDto reviewDTO){
        return reviewMapper.toEntity(reviewDTO);
    }

    public List<ReviewDto> convertListToReviewDTO(List<Review> reviews){
        return reviewMapper.toDTOList(reviews);
    }

    public List<Review> convertListToReview(List<ReviewDto> reviewDtos){
        return reviewMapper.toEntityList(reviewDtos);
    }

    public GenreDto convertToGenreDTO(Genre genre){
        return genreMapper.toDTO(genre);
    }

    public Genre convertToGenre(GenreDto genreDTO){
        return genreMapper.toEntity(genreDTO);
    }

    public List<GenreDto> convertListToGenreDTO(List<Genre> genres){
        return genreMapper.toDTOList(genres);
    }

    public List<Genre> convertListToGenre(List<GenreDto> genreDtos){
        return genreMapper.toEntityList(genreDtos);
    }

    public MovieDto convertToMovieDTO(Movie movie){
        return movieMapper.toDTO(movie);
    }

    public Movie convertToMovie(MovieDto movieDTO){
        return movieMapper.toEntity(movieDTO);
    }

    public List<MovieDto> convertListToMovieDTO(List<Movie> movies){
        return movieMapper.toDTOList(movies);
    }

    public List<Movie> convertListToMovie(List<MovieDto> movieDtos){
        return movieMapper.toEntityList(movieDtos);
    }

    public SubscribeDto convertToSubscribeDTO(Subscribe subscribe){
        return subscribeMapper.toDTO(subscribe);
    }

    public Subscribe convertToSubscribe(SubscribeDto subscribeDTOs){
        return subscribeMapper.toEntity(subscribeDTOs);
    }

    public List<SubscribeDto> convertListToSubscribeDTO(List<Subscribe> subscribes){
        return subscribeMapper.toDTOList(subscribes);
    }

    public List<Subscribe> convertListToSubscribe(List<SubscribeDto> subscribeDtos){
        return subscribeMapper.toEntityList(subscribeDtos);
    }

    public UserDto convertToUserDTO(User user){
        return userMapper.toDTO(user);
    }

    public User convertToUser(UserDto userDTO){
        return userMapper.toEntity(userDTO);
    }

    public List<UserDto> convertListToUserDTO(List<User> users){
        return userMapper.toDTOList(users);
    }

    public List<User> convertListToUser(List<UserDto> userDtos){
        return userMapper.toEntityList(userDtos);
    }
}

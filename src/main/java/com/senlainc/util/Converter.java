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

    public ActorDTO convertToActorDTO(Actor actor){
        return actorMapper.toDTO(actor);
    }

    public Actor convertToActor(ActorDTO actorDTO){
        return actorMapper.toEntity(actorDTO);
    }

    public List<ActorDTO> convertListToActorDTO(List<Actor> actors){
        return actorMapper.toDTOList(actors);
    }

    public List<Actor> convertListToActor(List<ActorDTO> actorsDTOs){
        return actorMapper.toEntityList(actorsDTOs);
    }

    public CommentDTO convertToCommentDTO(Comment comment){
        return commentMapper.toDTO(comment);
    }

    public Comment convertToComment(CommentDTO commentDTO){
        return commentMapper.toEntity(commentDTO);
    }

    public List<CommentDTO> convertListToCommentDTO(List<Comment> comments){
        return commentMapper.toDTOList(comments);
    }

    public List<Comment> convertListToComment(List<CommentDTO> commentDTOs){
        return commentMapper.toEntityList(commentDTOs);
    }

    public FilmCompanyDTO convertToFilmCompanyDTO(FilmCompany filmCompany){
        return filmCompanyMapper.toDTO(filmCompany);
    }

    public FilmCompany convertToFilmCompany(FilmCompanyDTO filmCompanyDTO){
        return filmCompanyMapper.toEntity(filmCompanyDTO);
    }

    public List<FilmCompanyDTO> convertListToFilmCompanyDTO(List<FilmCompany> filmCompanies){
        return filmCompanyMapper.toDTOList(filmCompanies);
    }

    public List<FilmCompany> convertListToFilmCompany(List<FilmCompanyDTO> filmCompanyDTOs){
        return filmCompanyMapper.toEntityList(filmCompanyDTOs);
    }

    public ReviewDTO convertToReviewDTO(Review review){
        return reviewMapper.toDTO(review);
    }

    public Review convertToReview(ReviewDTO reviewDTO){
        return reviewMapper.toEntity(reviewDTO);
    }

    public List<ReviewDTO> convertListToReviewDTO(List<Review> reviews){
        return reviewMapper.toDTOList(reviews);
    }

    public List<Review> convertListToReview(List<ReviewDTO> reviewDTOs){
        return reviewMapper.toEntityList(reviewDTOs);
    }

    public GenreDTO convertToGenreDTO(Genre genre){
        return genreMapper.toDTO(genre);
    }

    public Genre convertToGenre(GenreDTO genreDTO){
        return genreMapper.toEntity(genreDTO);
    }

    public List<GenreDTO> convertListToGenreDTO(List<Genre> genres){
        return genreMapper.toDTOList(genres);
    }

    public List<Genre> convertListToGenre(List<GenreDTO> genreDTOs){
        return genreMapper.toEntityList(genreDTOs);
    }

    public MovieDTO convertToMovieDTO(Movie movie){
        return movieMapper.toDTO(movie);
    }

    public Movie convertToMovie(MovieDTO movieDTO){
        return movieMapper.toEntity(movieDTO);
    }

    public List<MovieDTO> convertListToMovieDTO(List<Movie> movies){
        return movieMapper.toDTOList(movies);
    }

    public List<Movie> convertListToMovie(List<MovieDTO> movieDTOs){
        return movieMapper.toEntityList(movieDTOs);
    }

    public SubscribeDTO convertToSubscribeDTO(Subscribe subscribe){
        return subscribeMapper.toDTO(subscribe);
    }

    public Subscribe convertToSubscribe(SubscribeDTO subscribeDTOs){
        return subscribeMapper.toEntity(subscribeDTOs);
    }

    public List<SubscribeDTO> convertListToSubscribeDTO(List<Subscribe> subscribes){
        return subscribeMapper.toDTOList(subscribes);
    }

    public List<Subscribe> convertListToSubscribe(List<SubscribeDTO> subscribeDTOs){
        return subscribeMapper.toEntityList(subscribeDTOs);
    }

    public UserDTO convertToUserDTO(User user){
        return userMapper.toDTO(user);
    }

    public User convertToUser(UserDTO userDTO){
        return userMapper.toEntity(userDTO);
    }

    public List<UserDTO> convertListToUserDTO(List<User> users){
        return userMapper.toDTOList(users);
    }

    public List<User> convertListToUser(List<UserDTO> userDTOs){
        return userMapper.toEntityList(userDTOs);
    }
}

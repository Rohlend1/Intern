package com.senlainc.repositories;

import com.senlainc.models.Genre;
import com.senlainc.models.Movie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
@Transactional
public class GenreRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Genre> findAll() {
        return entityManager.createQuery("SELECT m FROM Genre m", Genre.class).getResultList();
    }

    public void save(Genre genre) {
        entityManager.persist(genre);
    }

    @Transactional(readOnly = true)
    public Genre findById(int id){
        return entityManager.find(Genre.class, id);
    }

    public void delete(Genre genre){
        entityManager.remove(genre);
    }

    @Transactional(readOnly = true)
    public List<Genre> findGenreLike(String ch){
        return entityManager.createNamedQuery("findGenreLike", Genre.class).setParameter("character", ch).getResultList();
    }

    @Transactional(readOnly = true)
    public List<Genre> findByMoviesAmountGreaterThanAndMoviesDurationGreaterThan(long amount, int duration){
        return entityManager.createNativeQuery("SELECT genre.genre_id, genre.name FROM genre " +
                        "JOIN movie_genre ON genre.genre_id = movie_genre.genre_id " +
                        "JOIN movie ON movie.movie_id = movie_genre.movie_id  "+
                        "WHERE duration > :duration " +
                        "GROUP BY genre.genre_id, genre.name "+
                        "HAVING COUNT(genre.genre_id) > :amount", Genre.class)
                .setParameter("duration", duration)
                .setParameter("amount", amount)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Genre findMostPopularGenre(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Genre> query = cb.createQuery(Genre.class);
        Root<Movie> movieRoot = query.from(Movie.class);
        Join<Movie, Genre> genreJoin = movieRoot.join("genres");

        query
                .select(genreJoin)
                .groupBy(genreJoin.get("id"))
                .orderBy(cb.desc(cb.count(genreJoin)));

        TypedQuery<Genre> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult(0);
        typedQuery.setMaxResults(1);

        return typedQuery.getSingleResult();
    }
}

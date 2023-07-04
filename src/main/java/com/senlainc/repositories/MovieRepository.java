package com.senlainc.repositories;

import com.senlainc.models.FilmCompany;
import com.senlainc.models.Movie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class MovieRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Movie> findAll() {
        return entityManager.createQuery("SELECT m FROM Movie m").getResultList();
    }

    public void save(Movie movie) {
        entityManager.persist(movie);
    }

    @Transactional(readOnly = true)
    public Movie findById(int id){
        return entityManager.find(Movie.class, id);
    }

    public void delete(Movie movie){
        entityManager.remove(movie);
    }

    public void update(Movie movie){
        entityManager.merge(movie);
    }

    @Transactional(readOnly = true)
    public List<Movie> findByDateOfReleaseBetween(int year1, int year2){
        return entityManager.createQuery("SELECT m FROM Movie m where YEAR(date_of_release) BETWEEN :year1 AND :year2", Movie.class)
                .setParameter("year1", year1)
                .setParameter("year2", year2).getResultList();
    }

    @Transactional(readOnly = true)
    public List<Movie> findByFilmCompanyEqualsAndBoxOfficeGreaterThan(FilmCompany filmCompany, double millions){
        return entityManager.createQuery("SELECT m FROM Movie m WHERE filmCompany = :filmCompany AND box_office > :boxOffice", Movie.class)
                .setParameter("filmCompany", filmCompany)
                .setParameter("boxOffice", millions).getResultList();
    }

    @Transactional(readOnly = true)
    public List<Movie> findByActorsLessThan(long amount){
        return entityManager.createQuery("SELECT m FROM Movie m JOIN m.actors a GROUP BY m HAVING COUNT(m) < :amount", Movie.class)
                .setParameter("amount", amount)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public List<Movie> findAllPagination(int page, int moviesPerPage){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movie> query = cb.createQuery(Movie.class);
        Root<Movie> root = query.from(Movie.class);

        query.select(root);

        TypedQuery<Movie> typedQuery = entityManager.createQuery(query);

        typedQuery.setFirstResult((page*moviesPerPage)-moviesPerPage);
        typedQuery.setMaxResults(moviesPerPage);

        return typedQuery.getResultList();
    }
}

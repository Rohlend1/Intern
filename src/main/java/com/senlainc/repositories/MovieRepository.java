package com.senlainc.repositories;

import com.senlainc.models.FilmCompany;
import com.senlainc.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
@Transactional
public class MovieRepository {

    private final EntityManagerFactory entityManagerFactory;

    private final EntityManager entityManager;

    @Autowired
    public MovieRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Transactional(readOnly = true)
    public List<Movie> findAll() {
        return entityManager.createQuery("SELECT m FROM Movie m").getResultList();
    }

    public void save(Movie movie) {
        entityManager.persist(movie);
    }

    @Transactional(readOnly = true)
    public Movie findById(int id){
        return entityManager.find(Movie.class,id);
    }

    public void delete(Movie movie){
        entityManager.remove(movie);
    }

    @Transactional(readOnly = true)
    public List<Movie> findByDateOfReleaseBetween(int year1, int year2){
        return entityManager.createQuery("SELECT m FROM Movie m where YEAR(date_of_release) BETWEEN :year1 AND :year2", Movie.class)
                .setParameter("year1",year1)
                .setParameter("year2",year2).getResultList();
    }

    @Transactional(readOnly = true)
    public List<Movie> findByFilmCompanyEqualsAndBoxOfficeGreaterThan(FilmCompany filmCompany, double millions){
        return entityManager.createQuery("SELECT m FROM Movie m WHERE film_company = :filmCompanyId AND box_office > :boxOffice", Movie.class)
                .setParameter("filmCompanyId",filmCompany.getId())
                .setParameter("boxOffice",millions*1_000_000).getResultList();
    }

    @Transactional(readOnly = true)
    public List<Movie> findByActorsLessThan(long amount){
        return entityManager.createQuery("SELECT m FROM Movie m JOIN m.actors a GROUP BY m HAVING COUNT(m) < :amount", Movie.class)
                .setParameter("amount", amount)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public List<Movie> findAllPagination(int page, int moviesPerPage){
        return entityManager.createQuery("SELECT m FROM Movie m", Movie.class)
                .setFirstResult(page)
                .setMaxResults(moviesPerPage).getResultList();
    }
}

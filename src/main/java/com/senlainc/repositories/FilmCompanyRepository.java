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
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class FilmCompanyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<FilmCompany> findAll() {
        return entityManager.createQuery("SELECT m FROM FilmCompany m", FilmCompany.class).getResultList();
    }

    public void save(FilmCompany filmCompany) {
        entityManager.persist(filmCompany);
    }

    @Transactional(readOnly = true)
    public FilmCompany findById(int id){
        return entityManager.find(FilmCompany.class, id);
    }

    public void delete(FilmCompany filmCompany){
        entityManager.remove(filmCompany);
    }

    public void update(FilmCompany filmCompany){
        entityManager.merge(filmCompany);
    }

    @Transactional(readOnly = true)
    public FilmCompany findByName(String name){
        return entityManager.createQuery("SELECT fc FROM FilmCompany fc WHERE name = :name", FilmCompany.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Transactional(readOnly = true)
    public List<FilmCompany> findByDateOfFoundationLessThan(int year){
        return entityManager.createQuery("SELECT fc FROM FilmCompany fc WHERE YEAR(date_of_foundation) < :year", FilmCompany.class)
                .setParameter("year", year)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public List<FilmCompany> findAllSortByName(){
        return entityManager.createQuery("SELECT fc FROM FilmCompany fc ORDER BY fc.name ASC", FilmCompany.class).getResultList();
    }

    @Transactional(readOnly = true)
    public List<FilmCompany> findByNameWithTwoWordsAndDateOfFoundationBetween(int year1, int year2){
        return entityManager.createQuery("SELECT fc FROM FilmCompany fc WHERE fc.name LIKE '% %' AND YEAR(date_of_foundation) BETWEEN :year1 AND :year2", FilmCompany.class)
                .setParameter("year1", year1)
                .setParameter("year2", year2)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public FilmCompany findLeastPopularFilmCompany(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<FilmCompany> query = cb.createQuery(FilmCompany.class);
        Root<Movie> movieRoot = query.from(Movie.class);
        Join<Movie, FilmCompany> filmCompanyMovieJoin = movieRoot.join("filmCompany");

        query
                .select(filmCompanyMovieJoin)
                .groupBy(filmCompanyMovieJoin.get("id"))
                .orderBy(cb.asc(cb.count(filmCompanyMovieJoin)));

        TypedQuery<FilmCompany> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult(0);
        typedQuery.setMaxResults(1);

        return typedQuery.getSingleResult();
    }
}

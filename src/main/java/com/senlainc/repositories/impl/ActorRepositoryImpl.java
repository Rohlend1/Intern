package com.senlainc.repositories.impl;

import com.senlainc.models.Actor;
import com.senlainc.repositories.ActorRepository;
import com.senlainc.util.Gender;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ActorRepositoryImpl implements ActorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Actor> findAll() {
        return entityManager.createQuery("SELECT m FROM Actor m", Actor.class).getResultList();
    }

    public void saveOrUpdate(Actor actor){
        if(actor.getId() != null){
            entityManager.merge(actor);
        }
        else {
            entityManager.persist(actor);
        }
    }

    @Transactional(readOnly = true)
    public Actor findById(int id){
        return entityManager.find(Actor.class, id);
    }

    public void delete(Actor actor){
        entityManager.remove(actor);
    }

    public void delete(int id){
        entityManager.createQuery("DELETE a FROM Actor WHERE a.id = :id").setParameter("id", id);
    }

    public List<Actor> findByGenderAndFromCountry(Gender gender, String country){
        return entityManager.createQuery("SELECT a FROM Actor a WHERE a.gender = :gender AND a.country = : country", Actor.class)
                .setParameter("gender", gender)
                .setParameter("country", country)
                .getResultList();
    }

    public List<Actor> findByMoviesMoreThanAndBornInTwentiethCentury(long amount){
        return entityManager.createQuery("SELECT a FROM Actor a " +
                        "JOIN a.movies " +
                        "WHERE YEAR(a.birthDate) BETWEEN 1901 AND 2000" +
                        "GROUP BY a " +
                        "HAVING COUNT(a) > :amount", Actor.class)
                .setParameter("amount", amount)
                .getResultList();
    }

    public List<Actor> findByCountryEqualsAndLastNameEndsWithAndAgeLessThan(String country, String endsWith, int years){
        return entityManager.createQuery("SELECT a FROM Actor a " +
                "WHERE a.country = :country " +
                "AND a.lastName LIKE :endsWith " +
                "AND a.age < :years", Actor.class)
                .setParameter("country", country)
                .setParameter("endsWith", endsWith)
                .setParameter("years", years)
                .getResultList();
    }
}

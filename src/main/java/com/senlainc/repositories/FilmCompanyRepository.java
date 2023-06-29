package com.senlainc.repositories;

import com.senlainc.models.FilmCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
@Transactional
public class FilmCompanyRepository {

    private final EntityManagerFactory entityManagerFactory;

    private final EntityManager entityManager;

    @Autowired
    public FilmCompanyRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Transactional(readOnly = true)
    public List<FilmCompany> findAll() {
        return entityManager.createQuery("SELECT m FROM FilmCompany m", FilmCompany.class).getResultList();
    }

    public void save(FilmCompany filmCompany) {
        entityManager.persist(filmCompany);
    }

    @Transactional(readOnly = true)
    public FilmCompany findById(int id){
        return entityManager.find(FilmCompany.class,id);
    }

    public void delete(FilmCompany filmCompany){
        entityManager.remove(filmCompany);
    }

    @Transactional(readOnly = true)
    public FilmCompany findByName(String name){
        return entityManager.createQuery("SELECT fc FROM FilmCompany fc WHERE name = :name", FilmCompany.class)
                .setParameter("name",name)
                .getSingleResult();
    }
}

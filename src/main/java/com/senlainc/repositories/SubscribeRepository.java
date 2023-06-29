package com.senlainc.repositories;

import com.senlainc.models.Subscribe;
import com.senlainc.models.SubscribeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
@Transactional
public class SubscribeRepository {

    private final EntityManagerFactory entityManagerFactory;

    private final EntityManager entityManager;

    @Autowired
    public SubscribeRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Transactional(readOnly = true)
    public List<Subscribe> findAll() {
        return entityManager.createQuery("SELECT m Subscribe Movie m", Subscribe.class).getResultList();
    }

    public void save(Subscribe subscribe) {
        entityManager.persist(subscribe);
    }

    @Transactional(readOnly = true)
    public Subscribe findById(SubscribeId id){
        return entityManager.find(Subscribe.class,id);
    }

    public void delete(Subscribe subscribe){
        entityManager.remove(subscribe);
    }
}

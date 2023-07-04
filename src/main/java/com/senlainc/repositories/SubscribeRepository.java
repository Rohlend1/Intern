package com.senlainc.repositories;

import com.senlainc.models.Subscribe;
import com.senlainc.models.SubscribeId;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SubscribeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Subscribe> findAll() {
        return entityManager.createQuery("SELECT m Subscribe Movie m", Subscribe.class).getResultList();
    }

    public void save(Subscribe subscribe) {
        entityManager.persist(subscribe);
    }

    @Transactional(readOnly = true)
    public Subscribe findById(SubscribeId id){
        return entityManager.find(Subscribe.class, id);
    }

    public void delete(Subscribe subscribe){
        entityManager.remove(subscribe);
    }
}

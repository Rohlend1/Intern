package com.senlainc.repositories;

import com.senlainc.models.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
@Transactional
public class ActorRepository{

    private final EntityManagerFactory entityManagerFactory;

    private final EntityManager entityManager;

    @Autowired
    public ActorRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Transactional(readOnly = true)
    public List<Actor> findAll() {
        return entityManager.createQuery("SELECT m FROM Actor m", Actor.class).getResultList();
    }

    public void save(Actor actor) {
        entityManager.persist(actor);
    }

    @Transactional(readOnly = true)
    public Actor findById(int id){
        return entityManager.find(Actor.class,id);
    }

    public void delete(Actor actor){
        entityManager.remove(actor);
    }
}

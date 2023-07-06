package com.senlainc.repositories.impl;

import com.senlainc.models.Actor;
import com.senlainc.repositories.ActorRepository;
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
            entityManager.persist(actor);
        }
        else {
            entityManager.merge(actor);
        }
    }

    @Transactional(readOnly = true)
    public Actor findById(int id){
        return entityManager.find(Actor.class, id);
    }

    public void delete(Actor actor){
        entityManager.remove(actor);
    }
}

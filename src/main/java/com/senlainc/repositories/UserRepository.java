package com.senlainc.repositories;

import com.senlainc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
@Transactional
public class UserRepository {

    private final EntityManagerFactory entityManagerFactory;

    private final EntityManager entityManager;

    @Autowired
    public UserRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return entityManager.createQuery("SELECT m User Movie m", User.class).getResultList();
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional(readOnly = true)
    public User findById(int id){
        return entityManager.find(User.class,id);
    }

    public void delete(User user){
        entityManager.remove(user);
    }
}

package com.senlainc.repositories;

import com.senlainc.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
@Transactional
public class ReviewRepository {

    private final EntityManagerFactory entityManagerFactory;

    private final EntityManager entityManager;

    @Autowired
    public ReviewRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Transactional(readOnly = true)
    public List<Review> findAll() {
        return entityManager.createQuery("SELECT m FROM Review m", Review.class).getResultList();
    }

    public void save(Review review) {
        entityManager.persist(review);
    }

    @Transactional(readOnly = true)
    public Review findById(int id){
        return entityManager.find(Review.class,id);
    }

    public void delete(Review review){
        entityManager.remove(review);
    }
}

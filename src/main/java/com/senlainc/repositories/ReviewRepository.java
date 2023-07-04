package com.senlainc.repositories;

import com.senlainc.models.Review;
import com.senlainc.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ReviewRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Review> findAll() {
        return entityManager.createQuery("SELECT m FROM Review m", Review.class).getResultList();
    }

    public void save(Review review) {
        entityManager.persist(review);
    }

    @Transactional(readOnly = true)
    public Review findById(int id){
        return entityManager.find(Review.class, id);
    }

    public void delete(Review review){
        entityManager.remove(review);
    }

    @Transactional(readOnly = true)
    public List<Review> findByUser(User user){
        return entityManager.createQuery("SELECT r FROM Review r WHERE owner = :owner_id", Review.class)
                .setParameter("owner_id", user)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public List<Review> findAllPagination(int page, int reviewsPerPage){
        return entityManager.createQuery("SELECT r FROM Review r", Review.class)
                .setFirstResult((page*reviewsPerPage)-reviewsPerPage)
                .setMaxResults(reviewsPerPage)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public List<Review> findByContentGreaterThanAndUpdated(int amountOfCharacters){
        return entityManager.createQuery("SELECT r FROM Review r " +
                        "WHERE LENGTH(r.content) > :amount_of_characters " +
                        "AND r.updatedAt IS NOT NULL", Review.class)
                .setParameter("amount_of_characters", amountOfCharacters)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public List<Review> findMonthEqualsMinuteDiffLessThanYearOfCreationEquals(int month, int minutes, int year){
        return entityManager.createQuery("SELECT r FROM Review r " +
                        "WHERE MONTH(r.createdAt) = :month " +
                        "AND EXTRACT(MINUTE FROM (r.updatedAt - r.createdAt)) < :minutes " +
                        "AND YEAR(r.createdAt) = :year", Review.class)
                .setParameter("month", month)
                .setParameter("minutes", minutes)
                .setParameter("year", year)
                .getResultList();
    }
}

package com.senlainc.repositories.impl;

import com.senlainc.models.Review;
import com.senlainc.models.User;
import com.senlainc.repositories.ReviewRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class ReviewRepositoryImpl implements ReviewRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Review> findAll() {
        return entityManager.createQuery("SELECT m FROM Review m", Review.class).getResultList();
    }

    public void saveOrUpdate(Review review){
        if(review.getId() != null){
            entityManager.merge(review);
        }
        else {
            entityManager.persist(review);
        }
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
    public List<Review> findAllPagination(int page, int moviesPerPage){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Review> query = cb.createQuery(Review.class);
        Root<Review> root = query.from(Review.class);

        query.select(root);

        TypedQuery<Review> typedQuery = entityManager.createQuery(query);

        typedQuery.setFirstResult((page*moviesPerPage)-moviesPerPage);
        typedQuery.setMaxResults(moviesPerPage);

        return typedQuery.getResultList();
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

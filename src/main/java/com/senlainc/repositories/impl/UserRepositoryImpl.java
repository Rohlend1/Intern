package com.senlainc.repositories.impl;

import com.senlainc.models.User;
import com.senlainc.repositories.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return entityManager.createQuery("SELECT m User Movie m", User.class).getResultList();
    }

    public void saveOrUpdate(User user){
        if(user.getId() != null){
            entityManager.merge(user);
        }
        else {
            entityManager.persist(user);
        }
    }

    @Transactional(readOnly = true)
    public User findById(int id){
        return entityManager.find(User.class, id);
    }

    public void delete(User user){
        entityManager.remove(user);
    }

    public void delete(int id){
        entityManager.createQuery("DELETE u FROM User WHERE u.id = :id").setParameter("id", id);
    }

    @Transactional(readOnly = true)
    public Long findTotalUsersWithNoEditedReviews(){
        return entityManager.createQuery("SELECT COUNT(DISTINCT r.owner) FROM Review r " +
                "WHERE r.updatedAt = r.createdAt OR r.updatedAt IS NULL", Long.class).getSingleResult();
    }

    @Transactional(readOnly = true)
    public List<User> findByUsernameMatchingToRegexp(String regex){
        return entityManager.createNativeQuery("SELECT * FROM users u WHERE u.username ~ :regex", User.class)
                .setParameter("regex", regex)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public List<User> findByUsernameConsistsOfTextAndHasAtLeastOneReview(){
        return entityManager.createNativeQuery("SELECT * From users WHERE users.username ~ '^[a-zA-Z\\s]*$' " +
                "AND users.user_id IN (SELECT DISTINCT owner FROM Review)", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    public User findByUsername(String username){
        return entityManager.createQuery("SELECT u From User u WHERE u.username = :username",User.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}

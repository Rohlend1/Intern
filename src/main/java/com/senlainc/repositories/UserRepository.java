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

    @Transactional(readOnly = true)
    public Long findTotalUsersWithNoEditedReviews(){
        return entityManager.createQuery("SELECT COUNT(DISTINCT r.owner) FROM Review r " +
                "WHERE r.updatedAt = r.createdAt OR r.updatedAt IS NULL", Long.class).getSingleResult();
    }

    @Transactional(readOnly = true)
    public List<User> findByUsernameMatchingToRegexp(String regex){
        return entityManager.createNativeQuery("SELECT * FROM users u WHERE u.username ~ :regex", User.class)
                .setParameter("regex",regex)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public List<User> findByUsernameConsistsOfTextAndHasAtLeastOneReview(){
        return entityManager.createNativeQuery("SELECT * From users WHERE users.username ~ '^[a-zA-Z\\s]*$' " +
                "AND users.user_id IN (SELECT DISTINCT owner FROM Review)",User.class).getResultList();
    }

    @Transactional(readOnly = true)
    public User findByUsername(String username){
        return entityManager.createQuery("SELECT u From User u WHERE u.username = :username",User.class)
                .setParameter("username",username)
                .getSingleResult();
    }
}

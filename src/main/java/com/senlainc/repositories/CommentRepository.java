package com.senlainc.repositories;

import com.senlainc.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
@Transactional
public class CommentRepository {

    private final EntityManagerFactory entityManagerFactory;

    private final EntityManager entityManager;

    @Autowired
    public CommentRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Transactional(readOnly = true)
    public List<Comment> findAll() {
        return entityManager.createQuery("SELECT m FROM Comment m", Comment.class).getResultList();
    }

    public void save(Comment comment) {
        entityManager.persist(comment);
    }

    @Transactional(readOnly = true)
    public Comment findById(int id){
        return entityManager.find(Comment.class,id);
    }

    public void delete(Comment comment){
        entityManager.remove(comment);
    }
}

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

    @Autowired
    private final EntityManagerFactory entityManagerFactory;

    private final EntityManager entityManager;

    public CommentRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        entityManager = entityManagerFactory.createEntityManager();
    }


    @Transactional(readOnly = true)
    public List<Comment> findAll() {
        return entityManager.createQuery("SELECT m FROM Comment m").getResultList();
    }

    public void save(Comment comment) {
        entityManager.persist(comment);
    }

//    public Comment findOne(Comment comment){
//        return comments.stream().filter(a->a.equals(comment)).findAny().orElseThrow(ModelNotFoundException::new);
//    }
    @Transactional(readOnly = true)
    public Comment findById(int id){
        return entityManager.find(Comment.class,id);
    }

    public void delete(Comment comment){
        entityManager.remove(comment);
    }

}

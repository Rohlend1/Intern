package com.senlainc.repositories;

import com.senlainc.models.Comment;
import com.senlainc.models.Review;
import com.senlainc.models.User;
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

    @Transactional(readOnly = true)
    public List<Comment> findByParentCommentAndReviewEquals(Comment parentComment, Review review){
        return entityManager.createQuery("SELECT c FROM Comment c WHERE replyTo = :parentComment AND review = :review", Comment.class)
                .setParameter("parentComment",parentComment)
                .setParameter("review",review)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Long findTotalUniqueReviewsCommentedBy(User user){
        return entityManager.createQuery("SELECT COUNT(DISTINCT c.review) FROM Comment c WHERE owner = :user", Long.class)
                .setParameter("user",user).getSingleResult();
    }

    @Transactional(readOnly = true)
    public List<Comment> findByParentCommentSortedASC(Comment parentComment){
        return entityManager.createQuery("SELECT c FROM Comment c WHERE replyTo = :parentComment ORDER BY c.createdAt ASC", Comment.class)
                .setParameter("parentComment",parentComment)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Integer findIdMostPopularComment(){
        return entityManager.createQuery("SELECT c.id FROM Comment c GROUP BY c.id ORDER BY COUNT(c) DESC", Integer.class)
                .setFirstResult(0)
                .setMaxResults(1)
                .getSingleResult();
    }
}

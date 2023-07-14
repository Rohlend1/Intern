package com.senlainc.repositories.impl;

import com.senlainc.models.Comment;
import com.senlainc.models.Review;
import com.senlainc.models.User;
import com.senlainc.repositories.CommentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Comment> findAll() {
        return entityManager.createQuery("SELECT m FROM Comment m", Comment.class).getResultList();
    }

    public void saveOrUpdate(Comment comment){
        if(comment.getId() != null){
            entityManager.merge(comment);
        }
        else {
            entityManager.persist(comment);
        }
    }

    @Transactional(readOnly = true)
    public Comment findById(int id){
        return entityManager.find(Comment.class, id);
    }

    public void delete(Comment comment){
        entityManager.remove(comment);
    }

    public void delete(int id){
        entityManager.createQuery("DELETE c FROM Comment WHERE c.id = :id").setParameter("id", id);
    }

    @Transactional(readOnly = true)
    public List<Comment> findByParentCommentAndReviewEquals(Comment parentComment, Review review){
        return entityManager.createQuery("SELECT c FROM Comment c WHERE replyTo = :parentComment AND review = :review", Comment.class)
                .setParameter("parentComment", parentComment)
                .setParameter("review", review)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Long findTotalUniqueReviewsCommentedBy(User user){
        return entityManager.createQuery("SELECT COUNT(DISTINCT c.review) FROM Comment c WHERE owner = :user", Long.class)
                .setParameter("user", user)
                .getSingleResult();
    }

    @Transactional(readOnly = true)
    public List<Comment> findByParentCommentSortedASC(Comment parentComment){
        return entityManager.createQuery("SELECT c FROM Comment c WHERE replyTo = :parentComment ORDER BY c.createdAt ASC", Comment.class)
                .setParameter("parentComment", parentComment)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Integer findIdMostPopularComment() {
        return entityManager.createQuery("SELECT c.replyTo.id FROM Comment c WHERE c.replyTo IS NOT NULL GROUP BY c.replyTo.id ORDER BY COUNT(c) DESC", Integer.class)
                .setFirstResult(0)
                .setMaxResults(1)
                .getSingleResult();
    }
}

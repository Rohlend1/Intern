package com.senlainc.services.impl;

import com.senlainc.models.Comment;
import com.senlainc.models.Review;
import com.senlainc.models.User;
import com.senlainc.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senlainc.repositories.CommentRepository;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    public Comment findById(int id){
        return commentRepository.findById(id);
    }

    public void saveOrUpdate(Comment comment){
        commentRepository.saveOrUpdate(comment);
    }

    public void delete(Comment comment){
        commentRepository.delete(comment);
    }

    public List<Comment> findByParentCommentEqualsAndReviewEquals(Comment parentComment, Review review){
        return commentRepository.findByParentCommentAndReviewEquals(parentComment,review);
    }

    public Long findTotalUniqueReviewsCommentedBy(User user){
        return commentRepository.findTotalUniqueReviewsCommentedBy(user);
    }

    public List<Comment> findByParentCommentSortedASC(Comment parentComment){
        return commentRepository.findByParentCommentSortedASC(parentComment);
    }

    public Integer findIdMostPopularComment(){
        return commentRepository.findIdMostPopularComment();
    }
}

package com.senlainc.services.impl;

import com.senlainc.dto.comments.CommentDTO;
import com.senlainc.dto.reviews.ReviewDTO;
import com.senlainc.models.Comment;
import com.senlainc.models.Review;
import com.senlainc.models.User;
import com.senlainc.services.CommentService;
import com.senlainc.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senlainc.repositories.CommentRepository;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final Converter converter;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, Converter converter) {
        this.commentRepository = commentRepository;
        this.converter = converter;
    }

    public List<CommentDTO> findAll(){
        return converter.convertListToCommentDTO(commentRepository.findAll());
    }

    public CommentDTO findById(int id){
        return converter.convertToCommentDTO(commentRepository.findById(id));
    }

    public void saveOrUpdate(CommentDTO commentDTO){
        commentRepository.saveOrUpdate(converter.convertToComment(commentDTO));
    }

    public void delete(CommentDTO commentDTO){
        commentRepository.delete(converter.convertToComment(commentDTO));
    }

    public void delete(int id) {
        commentRepository.delete(id);
    }

    public List<CommentDTO> findByParentCommentEqualsAndReviewEquals(CommentDTO parentCommentDTO, ReviewDTO reviewDTO){
        Comment parentComment = converter.convertToComment(parentCommentDTO);
        Review review = converter.convertToReview(reviewDTO);
        return converter.convertListToCommentDTO(commentRepository.findByParentCommentAndReviewEquals(parentComment, review));
    }

    public Long findTotalUniqueReviewsCommentedBy(User user){
        return commentRepository.findTotalUniqueReviewsCommentedBy(user);
    }

    public List<CommentDTO> findByParentCommentSortedASC(CommentDTO parentCommentDTO){
        Comment parentComment = converter.convertToComment(parentCommentDTO);
        return converter.convertListToCommentDTO(commentRepository.findByParentCommentSortedASC(parentComment));
    }

    public Integer findIdMostPopularComment(){
        return commentRepository.findIdMostPopularComment();
    }
}

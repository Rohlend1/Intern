package com.senlainc.services.impl;

import com.senlainc.dto.comments.CommentDto;
import com.senlainc.dto.reviews.ReviewDto;
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

    public List<CommentDto> findAll(){
        return converter.convertListToCommentDTO(commentRepository.findAll());
    }

    public CommentDto findById(int id){
        return converter.convertToCommentDTO(commentRepository.findById(id));
    }

    public void saveOrUpdate(CommentDto commentDTO){
        commentRepository.saveOrUpdate(converter.convertToComment(commentDTO));
    }

    public void delete(CommentDto commentDTO){
        commentRepository.delete(converter.convertToComment(commentDTO));
    }

    public void delete(int id) {
        commentRepository.delete(id);
    }

    public List<CommentDto> findByParentCommentEqualsAndReviewEquals(CommentDto parentCommentDto, ReviewDto reviewDTO){
        Comment parentComment = converter.convertToComment(parentCommentDto);
        Review review = converter.convertToReview(reviewDTO);
        return converter.convertListToCommentDTO(commentRepository.findByParentCommentAndReviewEquals(parentComment, review));
    }

    public Long findTotalUniqueReviewsCommentedBy(User user){
        return commentRepository.findTotalUniqueReviewsCommentedBy(user);
    }

    public List<CommentDto> findByParentCommentSortedASC(CommentDto parentCommentDto){
        Comment parentComment = converter.convertToComment(parentCommentDto);
        return converter.convertListToCommentDTO(commentRepository.findByParentCommentSortedASC(parentComment));
    }

    public Integer findIdMostPopularComment(){
        return commentRepository.findIdMostPopularComment();
    }
}

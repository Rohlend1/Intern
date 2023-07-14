package com.senlainc.services;

import com.senlainc.dto.comments.CommentDTO;
import com.senlainc.dto.reviews.ReviewDTO;
import com.senlainc.models.Comment;
import com.senlainc.models.Review;
import com.senlainc.models.User;

import java.util.List;

public interface CommentService {

    List<CommentDTO> findAll();

    CommentDTO findById(int id);

    void saveOrUpdate(CommentDTO comment);

    void delete(CommentDTO comment);

    void delete(int id);

    List<CommentDTO> findByParentCommentEqualsAndReviewEquals(CommentDTO parentComment, ReviewDTO review);

    Long findTotalUniqueReviewsCommentedBy(User user);

    List<CommentDTO> findByParentCommentSortedASC(CommentDTO parentComment);

    Integer findIdMostPopularComment();
}

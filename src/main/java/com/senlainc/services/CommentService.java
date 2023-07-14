package com.senlainc.services;

import com.senlainc.dto.comments.CommentDto;
import com.senlainc.dto.reviews.ReviewDto;
import com.senlainc.models.User;

import java.util.List;

public interface CommentService {

    List<CommentDto> findAll();

    CommentDto findById(int id);

    void saveOrUpdate(CommentDto comment);

    void delete(CommentDto comment);

    void delete(int id);

    List<CommentDto> findByParentCommentEqualsAndReviewEquals(CommentDto parentComment, ReviewDto review);

    Long findTotalUniqueReviewsCommentedBy(User user);

    List<CommentDto> findByParentCommentSortedASC(CommentDto parentComment);

    Integer findIdMostPopularComment();
}

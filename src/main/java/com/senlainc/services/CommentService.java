package com.senlainc.services;

import com.senlainc.models.Comment;
import com.senlainc.models.Review;
import com.senlainc.models.User;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    Comment findById(int id);

    void saveOrUpdate(Comment comment);

    void delete(Comment comment);

    List<Comment> findByParentCommentEqualsAndReviewEquals(Comment parentComment, Review review);

    Long findTotalUniqueReviewsCommentedBy(User user);

    List<Comment> findByParentCommentSortedASC(Comment parentComment);

    Integer findIdMostPopularComment();
}

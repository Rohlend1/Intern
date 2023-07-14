package com.senlainc.repositories;

import com.senlainc.models.Comment;
import com.senlainc.models.Review;
import com.senlainc.models.User;

import java.util.List;

public interface CommentRepository {

    List<Comment> findAll();

    void saveOrUpdate(Comment comment);

    Comment findById(int id);

    void delete(Comment comment);

    void delete(int id);

    List<Comment> findByParentCommentAndReviewEquals(Comment parentComment, Review review);

    Long findTotalUniqueReviewsCommentedBy(User user);

    List<Comment> findByParentCommentSortedASC(Comment parentComment);

    Integer findIdMostPopularComment();
}

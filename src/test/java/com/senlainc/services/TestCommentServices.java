package com.senlainc.services;

import com.senlainc.config.SpringConfig;
import com.senlainc.models.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfig.class)
@Transactional
public class TestCommentServices {

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @Autowired
    private ReviewService reviewService;

    @Test
    public void testFindTotalUniqueReviewsCommentedBy() {
        assertEquals(3L, (long) commentService.findTotalUniqueReviewsCommentedBy(userService.findByUsername("Frog")));
    }

    @Test
    public void testFindByParentCommentEqualsAndReviewEquals(){
        List<Comment> expectedComments = new ArrayList<>();
        Comment comment = commentService.findById(1);
        List<Comment> actualComments = commentService.findByParentCommentEqualsAndReviewEquals(comment,reviewService.findAll().get(0));

        expectedComments.add(comment.getReplies().get(0));
        expectedComments.add(comment.getReplies().get(1));
        expectedComments.add(comment.getReplies().get(2));

        actualComments.sort(Comparator.comparingInt(Comment::getId));

        assertEquals(expectedComments,actualComments);
    }

    @Test
    public void testFindByParentCommentSortedASC(){
        Comment comment = commentService.findById(1);
        List<Comment> expectedComments = new ArrayList<>();

        expectedComments.add(comment.getReplies().get(0));
        expectedComments.add(comment.getReplies().get(1));
        expectedComments.add(comment.getReplies().get(2));

        expectedComments.sort(Comparator.comparing(Comment::getCreatedAt));

        assertEquals(expectedComments, commentService.findByParentCommentSortedASC(comment));
    }

    @Test
    public void testFindIdMostPopularComment(){
        assertEquals(1, commentService.findIdMostPopularComment());
    }
}

package com.senlainc.services;

import com.senlainc.config.SpringConfig;
import com.senlainc.models.Comment;
import com.senlainc.util.DatabasePreparer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TestCommentServices {

    private static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    private final CommentService commentService = context.getBean(CommentService.class);

    @BeforeAll
    public static void prepareDatabase(){
        DatabasePreparer.clearDatabase(context);
        DatabasePreparer.prepareDatabase(context);
    }

    @AfterAll
    public static void clearDatabase(){
        DatabasePreparer.clearDatabase(context);
    }

    @Test
    public void testFindTotalUniqueReviewsCommentedBy(){
        assertEquals(3L,(long) commentService.findTotalUniqueReviewsCommentedBy(DatabasePreparer.users.get(2)));
    }

    @Test
    public void testFindByParentCommentEqualsAndReviewEquals(){
        List<Comment> expectedComments = new ArrayList<>();
        List<Comment> actualComments = commentService.findByParentCommentEqualsAndReviewEquals(DatabasePreparer.comments.get(0),DatabasePreparer.reviews.get(0));

        expectedComments.add(commentService.findById(DatabasePreparer.replies.get(0).getId()));
        expectedComments.add(commentService.findById(DatabasePreparer.replies.get(2).getId()));
        expectedComments.add(commentService.findById(DatabasePreparer.replies.get(3).getId()));

        actualComments.sort(Comparator.comparingInt(Comment::getId));

        assertEquals(expectedComments,actualComments);
    }

    @Test
    public void testFindByParentCommentSortedASC(){
        List<Comment> expectedComments = new ArrayList<>();

        expectedComments.add(commentService.findById(DatabasePreparer.replies.get(0).getId()));
        expectedComments.add(commentService.findById(DatabasePreparer.replies.get(2).getId()));
        expectedComments.add(commentService.findById(DatabasePreparer.replies.get(3).getId()));

        expectedComments.sort(Comparator.comparing(Comment::getCreatedAt));

        assertEquals(expectedComments,commentService.findByParentCommentSortedASC(DatabasePreparer.comments.get(0)));
    }

    @Test
    public void testFindIdMostPopularComment(){
       assertEquals(DatabasePreparer.comments.get(0).getId(),commentService.findIdMostPopularComment());
    }
}

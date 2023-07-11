package com.senlainc.dto.comments;

import com.senlainc.models.Comment;
import com.senlainc.models.Review;
import com.senlainc.models.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class CommentDTO {

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private User owner;

    private Comment replyTo;

    private List<Comment> replies;

    private Review review;

}

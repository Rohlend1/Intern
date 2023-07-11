package com.senlainc.dto.reviews;

import com.senlainc.models.Comment;
import com.senlainc.models.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class ReviewDTO {

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private User owner;

    private List<Comment> comments;
}

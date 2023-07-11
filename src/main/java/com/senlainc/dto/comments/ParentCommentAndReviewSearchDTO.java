package com.senlainc.dto.comments;

import com.senlainc.dto.reviews.ReviewDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class ParentCommentAndReviewSearchDTO {

    @NotNull(message = "Parent comment can't be null")
    private CommentDTO parentComment;

    @NotNull(message = "Review can't be null")
    private ReviewDTO review;
}

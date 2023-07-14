package com.senlainc.dto.comments;

import com.senlainc.dto.reviews.ReviewDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class ParentCommentAndReviewSearchDto {

    @NotNull(message = "Parent comment can't be null")
    private CommentDto parentComment;

    @NotNull(message = "Review can't be null")
    private ReviewDto review;
}

package com.senlainc.dto.comments;

import com.senlainc.models.Review;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ParentCommentAndReviewSearchDTO {

    private CommentDTO parentComment;

    private Review review;
}

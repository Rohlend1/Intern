package com.senlainc.dto.comments;

import com.senlainc.dto.reviews.ReviewDto;
import com.senlainc.dto.users.UserDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class CommentDto {

    @NotBlank(message = "Description shouldn't be blank")
    @Size(max = 400, message = "Description shouldn't be more than 400 characters")
    private String description;

    @NotNull(message = "Creation time can't be null")
    @PastOrPresent(message = "Creation time can't indicate a future time")
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NotNull(message = "Owner can't be null")
    private UserDto owner;

    private CommentDto replyTo;

    private List<CommentDto> replies;

    private ReviewDto review;

}

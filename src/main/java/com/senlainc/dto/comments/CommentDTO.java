package com.senlainc.dto.comments;

import com.senlainc.dto.reviews.ReviewDTO;
import com.senlainc.dto.users.UserDTO;
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
public class CommentDTO {

    @NotBlank(message = "Description shouldn't be blank")
    @Size(max = 400, message = "Description shouldn't be more than 400 characters")
    private String description;

    @NotNull(message = "Creation time can't be null")
    @PastOrPresent(message = "Creation time can't indicate a future time")
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NotNull(message = "Owner can't be null")
    private UserDTO owner;

    private CommentDTO replyTo;

    private List<CommentDTO> replies;

    private ReviewDTO review;

}

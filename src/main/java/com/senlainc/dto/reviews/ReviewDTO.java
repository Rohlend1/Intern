package com.senlainc.dto.reviews;

import com.senlainc.dto.comments.CommentDTO;
import com.senlainc.dto.users.UserDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class ReviewDTO {

    @Size(min = 10, max = 3000, message = "Content must be between 10 and 3000 characters")
    private String content;

    @NotNull(message = "Creation date can't be null")
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NotNull(message = "Owner can't be null")
    private UserDTO owner;

    private List<CommentDTO> comments;
}

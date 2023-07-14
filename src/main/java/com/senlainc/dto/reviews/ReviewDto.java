package com.senlainc.dto.reviews;

import com.senlainc.dto.comments.CommentDto;
import com.senlainc.dto.users.UserDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class ReviewDto {

    @Size(min = 10, max = 3000, message = "Content must be between 10 and 3000 characters")
    private String content;

    @NotNull(message = "Creation date can't be null")
    @PastOrPresent(message = "Creation time can't indicate a future time")
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NotNull(message = "Owner can't be null")
    private UserDto owner;

    private List<CommentDto> comments;
}

package com.senlainc.dto.users;

import com.senlainc.dto.reviews.ReviewDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
@Getter
public class UserDto {

    @NotBlank(message = "Username can't be blank")
    private String username;

    private List<ReviewDto> reviews;
}

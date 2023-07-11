package com.senlainc.dto.users;

import com.senlainc.models.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDTO {

    private Integer id;

    private String username;

    private List<Review> reviews;
}

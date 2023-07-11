package com.senlainc.dto.actors;

import com.senlainc.dto.movies.MovieDTO;
import com.senlainc.util.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class ActorDTO {

    @NotBlank(message = "First name can't be blank")
    @Size(max = 100, message = "Invalid first name. First name should be between 2 and 100")
    private String firstName;

    @NotBlank(message = "Last name can't be blank")
    @Size(max = 100, message = "Invalid last name. Last name should be between 2 and 100")
    private String lastName;

    @NotNull(message = "Gender can't be null")
    private Gender gender;

    @NotEmpty(message = "Country shouldn't be blank")
    private String country;

    @NotNull(message = "Birth date shouldn't be empty")
    @PastOrPresent(message = "Birth date can't indicate a future time")
    private LocalDate birthDate;

    @Min(value = 0, message = "Age shouldn't be less than 0")
    @Max(value = 110, message = "Age shouldn't be greater than 110")
    private Integer age;

    private List<MovieDTO> movies;
}

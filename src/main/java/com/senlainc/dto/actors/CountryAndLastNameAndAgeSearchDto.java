package com.senlainc.dto.actors;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Setter
@Getter
public class CountryAndLastNameAndAgeSearchDto {

    @Min(value = 0, message = "Age shouldn't be less than 0")
    @Max(value = 110, message = "Age shouldn't be more than 110")
    private Integer age;

    @NotBlank(message = "Country can't be blank")
    @Size(max = 50, message = "Country name must be between 2 and 50 characters")
    private String country;

    @NotNull(message = "Ends with can't be null")
    private String endsWith;
}

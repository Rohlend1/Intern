package com.senlainc.dto.actors;

import com.senlainc.util.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class GenderAndCountrySearchDTO {

    @NotBlank(message = "Country can't be blank")
    @Size(max = 50, message = "Country name must be between 2 and 50 characters")
    private String country;

    @NotNull(message = "Gender can't be null")
    private Gender gender;
}

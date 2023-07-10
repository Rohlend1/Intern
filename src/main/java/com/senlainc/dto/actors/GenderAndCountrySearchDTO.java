package com.senlainc.dto.actors;

import com.senlainc.util.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenderAndCountrySearchDTO {

    private String country;

    private Gender gender;
}

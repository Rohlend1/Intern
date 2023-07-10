package com.senlainc.dto.actors;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CountryAndLastNameAndAgeSearchDTO {

    private Integer years;

    private String country;

    private String endsWith;
}

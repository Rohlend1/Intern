package com.senlainc.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class DateBetweenSearchDTO {

    @NotNull(message = "Year can't be null")
    private Integer year1;

    @NotNull(message = "Year can't be null")
    private Integer year2;
}

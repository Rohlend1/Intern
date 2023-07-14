package com.senlainc.dto.genres;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Setter
@Getter
public class AmountAndDurationSearchDto {

    @Min(value = 1, message = "Total amount of genres to search can't be less than 1")
    private Long amount;

    @Min(value = 1, message = "Duration can't be less than 1")
    private Integer duration;
}

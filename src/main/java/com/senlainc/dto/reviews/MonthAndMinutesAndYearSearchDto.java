package com.senlainc.dto.reviews;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Setter
@Getter
public class MonthAndMinutesAndYearSearchDto {

    @NotNull(message = "Year can't be null")
    private Integer year;

    @PositiveOrZero(message = "Minutes can't be negative")
    @Max(value = 59, message = "Minutes can't be greater than 59")
    private Integer minutes;

    @Min(value = 1, message = "Month can't be less than 1")
    @Max(value = 12, message = "Month can't be greater than 12")
    private Integer month;
}

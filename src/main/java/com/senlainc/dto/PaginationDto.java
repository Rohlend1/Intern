package com.senlainc.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.PositiveOrZero;

@Setter
@Getter
public class PaginationDto {

    @PositiveOrZero(message = "Page can't be negative")
    private Integer page;

    @PositiveOrZero(message = "Items per page can't be negative")
    private Integer itemsPerPage;
}

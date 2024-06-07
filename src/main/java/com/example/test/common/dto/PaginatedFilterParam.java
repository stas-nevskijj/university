package com.example.test.common.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedFilterParam {

    private static final int DEFAULT_PAGE_SIZE = 5;
    private static final int DEFAULT_PAGE_NUMBER = 0;

    @Positive
    private int pageSize = DEFAULT_PAGE_SIZE;

    @PositiveOrZero
    private int pageNumber = DEFAULT_PAGE_NUMBER;
}

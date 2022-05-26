package com.radax.products.controller;

import lombok.Getter;
import lombok.Setter;
import org.openapitools.jackson.nullable.JsonNullable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductDto {
    private JsonNullable<LocalDateTime> dateExpiry = JsonNullable.undefined();
    private JsonNullable<BigDecimal> price = JsonNullable.undefined();
}

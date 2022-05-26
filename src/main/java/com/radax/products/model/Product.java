package com.radax.products.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal price;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime dateExpiry;
    private boolean valid;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String source;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;
}

package com.radax.products.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product", schema = "test_shop_db")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Article {
    @Id
    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column(name = "date_expiry")
    private LocalDateTime dateExpiry;

    private String source;
}

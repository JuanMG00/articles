package com.radax.products.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


/*
 * ObjectMapper so Jackson can correctly serialize and deserialize classes containing JsonNullable wrapped fields
 */
@Configuration
@RequiredArgsConstructor
public class JacksonConfiguration {
    private final ObjectMapper objectMapper;

    @PostConstruct
    ObjectMapper jacksonObjectMapper() {
        objectMapper.registerModule(new JsonNullableModule());
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}

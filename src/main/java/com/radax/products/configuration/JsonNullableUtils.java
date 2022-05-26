package com.radax.products.configuration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openapitools.jackson.nullable.JsonNullable;

import java.util.function.Consumer;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JsonNullableUtils {

    public static <T> void changeIfPresent(JsonNullable<T> nullable, Consumer<T> consumer) {
        if (nullable.isPresent()) {
            consumer.accept(nullable.get());
        }
    }
}

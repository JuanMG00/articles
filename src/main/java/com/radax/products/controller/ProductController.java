package com.radax.products.controller;

import com.radax.products.configuration.JsonNullableUtils;
import com.radax.products.domain.Article;
import com.radax.products.model.Product;
import com.radax.products.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ProductController {
    @Value("${server.port}")
    private int serverPort;

    @Value("${spring.application.name}")
    private String serverName;
    private final ProductsRepository productsRepository;

    @GetMapping("/product-validator-service/validate-products")
    public List<Product> getProducts() {
        return productsRepository.findAll().stream().map(this::mapToProduct).collect(Collectors.toList());
    }

    @PatchMapping("/products-service/product/{id}")
    public ResponseEntity<Article> updateProduct(@PathVariable() String id, @RequestBody ProductDto productDto) {
        log.info(String.format("calling updateProduct from server port: %s", serverPort));
        var p = productsRepository.findById(id).orElseThrow();
        JsonNullableUtils.changeIfPresent(productDto.getDateExpiry(), p::setDateExpiry);
        JsonNullableUtils.changeIfPresent(productDto.getPrice(), p::setPrice);
        p.setSource(String.format("%s:%s", serverName, serverPort));
        return ResponseEntity.ok(productsRepository.save(p));
    }


    private Product mapToProduct(Article article) {
        return Product.builder()
                .name(article.getName())
                .dateExpiry(article.getDateExpiry())
                .price(article.getPrice())
                .valid(validate(article))
                .build();
    }

    private boolean validate(Article product) {
        return product.getPrice() != null && product.getDateExpiry().isAfter(LocalDateTime.now());
    }

}

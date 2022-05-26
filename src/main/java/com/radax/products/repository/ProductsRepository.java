package com.radax.products.repository;

import com.radax.products.domain.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductsRepository extends CrudRepository<Article, String> {
    @Override
    List<Article> findAll();
}

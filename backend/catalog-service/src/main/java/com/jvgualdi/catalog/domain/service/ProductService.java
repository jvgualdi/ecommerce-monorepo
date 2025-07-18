package com.jvgualdi.catalog.domain.service;

import com.jvgualdi.catalog.domain.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product create(Product product);
    Optional<Product> getById(Long id);
    List<Product> getAll();
    Product update(Long id, Product product);
    void delete(Long id);
}

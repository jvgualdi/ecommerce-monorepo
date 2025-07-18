package com.jvgualdi.catalog.service;

import com.jvgualdi.catalog.domain.entity.Product;
import com.jvgualdi.catalog.domain.service.ProductService;
import com.jvgualdi.catalog.domain.repository.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Cacheable(value = "products", key = "#id")
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    @Cacheable(value = "products")
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    @CacheEvict(value = "products", allEntries = true)
    public Product update(Long id, Product product) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found: " + id));
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());

        if (product.getImageUrl() != null) {
            existing.setImageUrl(product.getImageUrl());
        }

        return productRepository.save(existing);
    }

    @Override
    @CacheEvict(value = "products", allEntries = true)
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new NoSuchElementException("Product not found: " + id);
        }
        productRepository.deleteById(id);
    }
}

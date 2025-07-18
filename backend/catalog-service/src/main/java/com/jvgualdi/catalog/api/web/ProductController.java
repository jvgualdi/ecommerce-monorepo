package com.jvgualdi.catalog.api.web;

import com.jvgualdi.catalog.domain.entity.Product;
import com.jvgualdi.catalog.api.dto.ProductDTO;
import com.jvgualdi.catalog.mapper.ProductMapper;
import com.jvgualdi.catalog.domain.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;
    private final ProductMapper mapper;

    public ProductController(ProductService service, ProductMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO product) {
        Product productEntity = mapper.toEntity(product);
        Product created = service.create(productEntity);
        ProductDTO createdDto = mapper.toDto(created);
        return ResponseEntity.created(URI.create("/api/products/" + created.getId()))
                .body(createdDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<Product> products = service.getAll();
        return ResponseEntity.ok(
                products.stream()
                        .map(mapper::toDto)
                        .toList()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO product) {
        Product productEntity = mapper.toEntity(product);
        ProductDTO updated = mapper.toDto(service.update(id, productEntity));
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

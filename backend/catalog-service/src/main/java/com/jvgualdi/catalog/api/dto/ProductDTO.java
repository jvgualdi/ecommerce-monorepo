package com.jvgualdi.catalog.api.dto;

import java.math.BigDecimal;

public record ProductDTO(String name, String description, BigDecimal price, String imageUrl, String brand, Integer stockQuantity) {
}

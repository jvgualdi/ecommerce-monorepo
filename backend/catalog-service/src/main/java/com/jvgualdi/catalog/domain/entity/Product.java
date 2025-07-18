package com.jvgualdi.catalog.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(length = 500)
    private String description;
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;
    @Column(name = "image_url", length = 255)
    private String imageUrl;
    private String brand;
    @JsonProperty("stock_quantity")
    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

}

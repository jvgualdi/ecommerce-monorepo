package com.jvgualdi.catalog.mapper;

import com.jvgualdi.catalog.domain.entity.Product;
import com.jvgualdi.catalog.api.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);

    Product toEntity(ProductDTO productDTO);
}

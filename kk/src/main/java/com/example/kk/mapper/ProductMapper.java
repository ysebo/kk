package com.example.kk.mapper;

import com.example.kk.dto.product.ProductResponse;
import com.example.kk.entites.Product;

import java.util.List;

public interface ProductMapper {
    ProductResponse toDto(Product product);
    List<ProductResponse> toDtoS(List<Product> all);
}

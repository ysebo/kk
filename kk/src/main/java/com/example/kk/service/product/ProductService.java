package com.example.kk.service.product;

import com.example.kk.dto.product.ProductRequest;
import com.example.kk.dto.product.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse getById(Long id);

    void register(ProductRequest productRequest);
    void deleteById(Long id );
    void updateById(Long id , ProductRequest productRequest);
    List<ProductResponse> getAll();

    void add(ProductRequest productRequest, Long userId);
}
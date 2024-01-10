package com.example.kk.service.product;

import com.example.kk.dto.product.ProductRequest;
import com.example.kk.dto.user.UserRequest;

public interface ProductService {
    void register(ProductRequest productRequest);
    void deleteById(Long id );
    void updateById(Long id , ProductRequest productRequest);
}

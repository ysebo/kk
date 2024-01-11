package com.example.kk.mapper.impl;
import com.example.kk.dto.product.ProductResponse;
import com.example.kk.entites.Product;
import com.example.kk.mapper.ProductMapper;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component

public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponse toDto(Product object) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(object.getId());
        productResponse.setType(object.getType());
        productResponse.setName(object.getName());
        productResponse.setDescription(object.getDescription());
        productResponse.setPrice(object.getPrice());
        productResponse.setCreated_date(object.getCreated_date());
        return productResponse;
    }



    @Override
    public List<ProductResponse>toDtoS(List<Product>products){
        List<ProductResponse> productResponses = new ArrayList<>();
        for(Product product:products){
            productResponses.add(toDto(product));
        }
        return productResponses;
    }
}

package com.example.kk.controller;

import com.example.kk.dto.product.ProductRequest;
import com.example.kk.repositories.ProductRepository;
import com.example.kk.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@AllArgsConstructor

public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;
    @PostMapping("register")
    public void register(@RequestBody ProductRequest productRequest){
        productService.register(productRequest);
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id){
        productService.deleteById(id);
    }
    @PutMapping("update/{id}")
    public void update(@RequestBody ProductRequest productRequest, @PathVariable Long id ){
        productService.updateById(id, productRequest);
    }
}

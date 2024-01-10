package com.example.kk.service.product.impl;

import com.example.kk.dto.product.ProductRequest;
import com.example.kk.dto.product.ProductResponse;
import com.example.kk.entites.Product;
import com.example.kk.exception.NotFoundException;
import com.example.kk.repositories.ProductRepository;
import com.example.kk.enums.Type;
import com.example.kk.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;



    @Override
    public void register(ProductRequest productRequest) {
        if(productRequest.getName().contains("@")){
            throw new NotFoundException("You are fucking idiot " , HttpStatus.BAD_GATEWAY);
        }

        Product product = new Product();
        product.setName(productRequest.getName());
        product.setType(productRequest.getType());
        product.setPrize(productRequest.getPrize());
        product.setCreated_date(productRequest.getCreated_date());
        product.setDescription(productRequest.getDescription());
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Product > product = productRepository.findById(id);
        if(product.isEmpty()) {
            throw new NotFoundException("There is no product " , HttpStatus.BAD_GATEWAY);
        }
        else {
            productRepository.deleteById(id);
        }


    }

    @Override
    public void updateById(Long id, ProductRequest productRequest) {
        Optional<Product > product = productRepository.findById(id);
        if(product.isEmpty()) {
            System.out.println("product is empty ");
        }
        else{
            product.get().setName(productRequest.getName());
            product.get().setType(productRequest.getType());
            product.get().setDescription(productRequest.getDescription());
            product.get().setPrize(productRequest.getPrize());
            productRepository.save(product.get());
        }
    }
}

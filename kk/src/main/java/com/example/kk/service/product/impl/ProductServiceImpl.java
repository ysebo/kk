package com.example.kk.service.product.impl;

import com.example.kk.dto.product.ProductRequest;
import com.example.kk.dto.product.ProductResponse;
import com.example.kk.entites.Product;
import com.example.kk.exception.BadRequestException;
import com.example.kk.entites.User;
import com.example.kk.enums.Type;
import com.example.kk.exception.NotFoundException;
import com.example.kk.repositories.ProductRepository;
import com.example.kk.mapper.ProductMapper;
import com.example.kk.repositories.UserRepository;
import com.example.kk.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;
    private final UserRepository userRepository;


    @Override
    public void register(ProductRequest productRequest) {
        if(productRequest.getName().contains("@")){
            throw new NotFoundException("You are fucking idiot " , HttpStatus.BAD_GATEWAY);
        }

        Product product = new Product();
        product.setName(productRequest.getName());
        product.setType(productRequest.getType());
        product.setPrice(productRequest.getPrice());
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
        if (product.isEmpty())
            throw new NotFoundException("the product with id: "+id+" is empty!", HttpStatus.BAD_REQUEST);
        else{
            product.get().setName(productRequest.getName());
            product.get().setType(productRequest.getType());
            product.get().setDescription(productRequest.getDescription());
            product.get().setPrice(productRequest.getPrice());
            productRepository.save(product.get());
        }
    }

    @Override
    public List<ProductResponse> getAll() {
        return  mapper.toDtoS(productRepository.findAll());
    }
    public ProductResponse getById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new NotFoundException("product with id: "+id+" not found!", HttpStatus.BAD_GATEWAY);

        ProductResponse productResponse = new ProductResponse();
        productResponse.setName(product.get().getName());
        return  mapper.toDto(product.get());
    }

    @Override
    public void add(ProductRequest productRequest, Long userId) {
        Product product = new Product();
        Optional<User> user = userRepository.findById(userId);
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setCreated_date(LocalDateTime.now().toString());
        if(user.isEmpty()){
            throw new NotFoundException("Sanjar is gay " , HttpStatus.NOT_FOUND);
        }
        product.setOwner(user.get());


        if (!containsType(String.valueOf(productRequest.getType())))
            throw new BadRequestException("no type with name: "+productRequest.getType()+"!");
        product.setType(Type.valueOf(String.valueOf(productRequest.getType())));

        List<Product> products = new ArrayList<>();
        if (user.get().getUserProducts()!=null){
            products = user.get().getUserProducts();
        }
        products.add(product);
        user.get().setUserProducts(products);



        productRepository.save(product);
    }
    private boolean containsType(String type) {
        for (Type type1:Type.values()){
            if (type1.name().equalsIgnoreCase(type))
                return true;
        }
        return false;
    }
}


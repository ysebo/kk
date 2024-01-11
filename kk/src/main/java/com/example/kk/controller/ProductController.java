package com.example.kk.controller;
import com.example.kk.dto.product.ProductResponse;
import com.example.kk.dto.product.ProductRequest;
import com.example.kk.entites.User;
import com.example.kk.repositories.ProductRepository;
import com.example.kk.repositories.UserRepository;
import com.example.kk.service.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.kk.mapper.ProductMapper;



import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@AllArgsConstructor

public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ProductMapper productMapper;

    @PostMapping("/register")
    public void register(@RequestBody ProductRequest productRequest){
        productService.register(productRequest);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        productService.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public void update(@RequestBody ProductRequest productRequest, @PathVariable Long id ){
        productService.updateById(id, productRequest);
    }
    @PostMapping("/add/{userId}")
    public void add(@RequestBody ProductRequest productRequest,  @PathVariable Long userId){
        productService.add(productRequest, userId);
    }
    @GetMapping("/getAll")
    public List<ProductResponse> productResponses(){
        return productService.getAll();
    }
    @GetMapping("/get/{id}")
    public ProductResponse productResponse(@PathVariable Long id){
        return productService.getById(id);
    }
    @GetMapping("/{userId}")
    public List<ProductResponse>userProducts(@PathVariable Long userId){
        Optional<User> user = userRepository.findById(userId);
        return productMapper.toDtoS(user.get().getUserProducts());
    }

}

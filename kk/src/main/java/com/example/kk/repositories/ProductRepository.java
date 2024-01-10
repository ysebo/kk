package com.example.kk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.kk.entites.Product;

import java.util.Optional;

@Repository

public interface
ProductRepository extends JpaRepository<Product , Long> {
    static void save(Optional<Product> product) {
    }
}

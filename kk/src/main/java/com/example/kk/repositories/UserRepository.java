package com.example.kk.repositories;

import com.example.kk.entites.Product;
import com.example.kk.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface
UserRepository extends JpaRepository<User, Long> {

}
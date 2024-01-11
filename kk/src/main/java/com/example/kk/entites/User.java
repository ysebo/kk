package com.example.kk.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name = "users_table")
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String name;
    private Integer age ;
    private String course ;
    private String university;
    @OneToMany(cascade = CascadeType.ALL)
    List<Product> userProducts;
}

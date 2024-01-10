package com.example.kk.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.kk.enums.Type;


@Getter
@Entity
@Setter
@Table(name = "products")


public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String description;
    private Integer prize ;
    private String created_date;



}

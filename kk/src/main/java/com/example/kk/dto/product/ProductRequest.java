package com.example.kk.dto.product;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import com.example.kk.enums.Type;

@Getter
@Setter
public class ProductRequest {
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String description;
    private Integer prize ;
    private String created_date;

}

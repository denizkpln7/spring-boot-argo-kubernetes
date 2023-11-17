package com.example.productservice.model;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String category;

    private double balance;

}

package com.example.productservice.service;

import com.denizkpln.productservice.exception.CustomException;
import com.denizkpln.productservice.model.Product;
import com.denizkpln.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product findbyId(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(()->new CustomException("Not found by ıd","NOT_FOUND",404));
    }
}

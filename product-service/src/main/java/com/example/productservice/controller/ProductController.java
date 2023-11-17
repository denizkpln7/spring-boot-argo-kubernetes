package com.example.productservice.controller;

import com.denizkpln.productservice.model.Product;
import com.denizkpln.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product){
        log.info("product save");
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> findbyId(@PathVariable Long productId){
        log.info("product findbyıd");
        return ResponseEntity.ok(productService.findbyId(productId));
    }
}

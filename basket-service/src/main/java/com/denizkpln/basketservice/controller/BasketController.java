package com.denizkpln.basketservice.controller;


import com.denizkpln.basketservice.client.ProductServiceClient;
import com.denizkpln.basketservice.dto.BasketDto;
import com.denizkpln.basketservice.dto.Product;
import com.denizkpln.basketservice.model.Basket;
import com.denizkpln.basketservice.service.BasketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/basket")
@Slf4j
public class BasketController {
    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping
    public ResponseEntity<BasketDto> save(@RequestBody Basket basket){
        log.info("account save");

        return ResponseEntity.ok(basketService.save(basket));
    }

    @GetMapping("/{basketId}")
    public ResponseEntity<BasketDto> findbyId(@PathVariable Long basketId){
        log.info("account findbyıd");
        return ResponseEntity.ok(basketService.findbyId(basketId));
    }

}

package com.denizkpln.basketservice.service;

import com.denizkpln.basketservice.client.ProductServiceClient;
import com.denizkpln.basketservice.dto.BasketDto;
import com.denizkpln.basketservice.dto.Product;
import com.denizkpln.basketservice.exception.exception.CustomException;
import com.denizkpln.basketservice.model.Basket;
import com.denizkpln.basketservice.repository.BasketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final BasketRepository basketRepository;
    private final ProductServiceClient productServiceClient;

    public BasketService(BasketRepository basketRepository, ProductServiceClient productServiceClient) {
        this.basketRepository = basketRepository;
        this.productServiceClient = productServiceClient;
    }

    public BasketDto save(Basket basket) {
        List<Product> productList=basket.getProducts().stream().map((item)->productServiceClient.findbyId(item).getBody())
                .collect(Collectors.toList());
        Double sum = productList.stream()
                .mapToDouble((item)-> item.getBalance())
                .sum();
        basket.setCurrentbalance(sum);
        basket.setCreateDate(LocalDate.now());
        basketRepository.save(basket);

        BasketDto basketDto=new BasketDto().builder()
                .createDate(basket.getCreateDate())
                .currentbalance(basket.getCurrentbalance())
                .products(productList)
                .build();
        return basketDto;
    }

    public BasketDto findbyId(Long basketId) {
        Basket basket= basketRepository.findById(basketId)
                .orElseThrow(()->new CustomException("Not found by ıd","NOT_FOUND",404));
        List<Product> productList=basket.getProducts().stream().map((item)->productServiceClient.findbyId(item).getBody())
                .collect(Collectors.toList());

        BasketDto basketDto=new BasketDto().builder()
                .createDate(basket.getCreateDate())
                .currentbalance(basket.getCurrentbalance())
                .products(productList)
                .build();
        return basketDto;
    }
}

package com.denizkpln.basketservice.repository;

import com.denizkpln.basketservice.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket,Long> {
}

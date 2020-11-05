package com.gofluent.basket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gofluent.basket.model.BasketItem;

public interface BasketItemRepository extends JpaRepository<BasketItem, Integer> {

}

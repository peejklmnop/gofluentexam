package com.gofluent.basket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gofluent.basket.model.Basket;

public interface BasketRepository extends JpaRepository<Basket, Integer> {

}

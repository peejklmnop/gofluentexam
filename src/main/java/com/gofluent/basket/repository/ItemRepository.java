package com.gofluent.basket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gofluent.basket.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}

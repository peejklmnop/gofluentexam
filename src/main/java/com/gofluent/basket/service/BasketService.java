package com.gofluent.basket.service;

import java.math.BigDecimal;
import java.util.List;

import com.gofluent.basket.dto.AddItemToBasketRequestDto;
import com.gofluent.basket.dto.GetBasketItemListResponseDto;
import com.gofluent.basket.dto.RemoveItemFromBasketRequestDto;
import com.gofluent.basket.model.Basket;
import com.gofluent.basket.model.BasketItem;

public interface BasketService {

	
	public Basket createBasket(List<BasketItem> itemList);

	public Basket getBasketFromId(Integer id);

	public GetBasketItemListResponseDto addItemToBasket(AddItemToBasketRequestDto req);

	public GetBasketItemListResponseDto getBasketItemList(Integer basketId);

	public GetBasketItemListResponseDto removeItemFromBasket(RemoveItemFromBasketRequestDto req);

	public BigDecimal getBasketItemsTotalPrice(Integer basketId);

}

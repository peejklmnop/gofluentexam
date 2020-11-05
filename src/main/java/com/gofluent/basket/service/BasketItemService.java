package com.gofluent.basket.service;

import java.util.List;

import com.gofluent.basket.dto.BasketItemDto;
import com.gofluent.basket.model.BasketItem;

public interface BasketItemService {

	public BasketItem addBasketItem(BasketItem basketItem);

	public List<BasketItemDto> convertBasketItemListToDto(List<BasketItem> basketItemList);

	public void delete(BasketItem et);

}

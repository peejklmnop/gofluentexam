package com.gofluent.basket.dto;

import java.util.List;

public class GetBasketItemListResponseDto {
	
	private List<BasketItemDto> basketItemList;

	public GetBasketItemListResponseDto(List<BasketItemDto> basketItemList) {
		super();
		this.basketItemList = basketItemList;
	}

	public List<BasketItemDto> getBasketItemList() {
		return basketItemList;
	}

	public void setBasketItemList(List<BasketItemDto> basketItemList) {
		this.basketItemList = basketItemList;
	}
	
	

}

package com.gofluent.basket.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class RemoveItemFromBasketRequestDto  {

	@NotNull
	private Integer basketId;
	
	@NotNull
	private List<ItemAndQuantityDto> itemAndQuantityList;

	public RemoveItemFromBasketRequestDto(Integer basketId, List<ItemAndQuantityDto> itemAndQuantityList) {
		super();
		this.basketId = basketId;
		this.itemAndQuantityList = itemAndQuantityList;
	}

	public Integer getBasketId() {
		return basketId;
	}

	public void setBasketId(Integer basketId) {
		this.basketId = basketId;
	}

	public List<ItemAndQuantityDto> getItemAndQuantityList() {
		return itemAndQuantityList;
	}

	public void setItemAndQuantityList(List<ItemAndQuantityDto> itemAndQuantityList) {
		this.itemAndQuantityList = itemAndQuantityList;
	}	
	
}

package com.gofluent.basket.dto;

public class ItemAndQuantityDto {
	
	private Integer itemId;
	
	private Integer quantity;

	public ItemAndQuantityDto(Integer itemId, Integer quantity) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}

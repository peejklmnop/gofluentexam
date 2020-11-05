package com.gofluent.basket.dto;

import java.math.BigDecimal;

public class BasketItemDto {
	
	private String itemName;
	
	private BigDecimal price;
	
	private Integer quantity;

	public BasketItemDto(String itemName, BigDecimal price, Integer quantity) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}	

}

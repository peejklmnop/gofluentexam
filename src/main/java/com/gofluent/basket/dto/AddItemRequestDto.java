package com.gofluent.basket.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class AddItemRequestDto {

	@NotNull
	private String itemName;
	
	@NotNull
	private BigDecimal price;

	public AddItemRequestDto(String itemName, BigDecimal price) {
		super();
		this.itemName = itemName;
		this.price = price;
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
	
	
}

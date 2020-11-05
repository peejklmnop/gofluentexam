package com.gofluent.basket.dto;

public class GetBasketResponseDto {
	
	private Integer basketId;
	
	
	public GetBasketResponseDto(Integer basketId) {
		super();
		this.basketId = basketId;
	}

	public Integer getBasketId() {
		return basketId;
	}

	public void setBasketId(Integer basketId) {
		this.basketId = basketId;
	}
	

}

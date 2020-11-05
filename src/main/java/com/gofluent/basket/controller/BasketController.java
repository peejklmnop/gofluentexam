package com.gofluent.basket.controller;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gofluent.basket.dto.AddItemToBasketRequestDto;
import com.gofluent.basket.dto.GetBasketItemListResponseDto;
import com.gofluent.basket.dto.GetBasketResponseDto;
import com.gofluent.basket.dto.RemoveItemFromBasketRequestDto;
import com.gofluent.basket.model.Basket;
import com.gofluent.basket.service.BasketService;

@RestController
public class BasketController extends ErrorHandlingController{

	private BasketService basketService;

	@Autowired
	public BasketController(BasketService basketService) {
		super();
		this.basketService = basketService;
	}
	
	@GetMapping(value = "/basket/get")
	public ResponseEntity<GetBasketResponseDto> getBasket() {
		Basket newBasket = basketService.createBasket(new ArrayList<>());
		GetBasketResponseDto resp = new GetBasketResponseDto(newBasket.getId());
		return new ResponseEntity<>(resp ,HttpStatus.OK);
	}
	
	@PostMapping(value = "/basket/add-item")
	public ResponseEntity<GetBasketItemListResponseDto> addItemToBasket(@RequestBody AddItemToBasketRequestDto req) {
		
		GetBasketItemListResponseDto resp = basketService.addItemToBasket(req);
		return new ResponseEntity<>(resp ,HttpStatus.OK);
	}
	
	@PostMapping(value = "/basket/remove-item")
	public ResponseEntity<GetBasketItemListResponseDto> removeItemFromBasket(@RequestBody RemoveItemFromBasketRequestDto req) {
		
		GetBasketItemListResponseDto resp = basketService.removeItemFromBasket(req);
		return new ResponseEntity<>(resp ,HttpStatus.OK);
	}
	
	@GetMapping(value = "/basket/get-item-list/{basketId}")
	public ResponseEntity<GetBasketItemListResponseDto> getBasketItems(@PathVariable Integer basketId) {
		GetBasketItemListResponseDto resp = basketService.getBasketItemList(basketId);
		
		return new ResponseEntity<>(resp ,HttpStatus.OK);		
	}
	
	@GetMapping(value = "/basket/get-total-price/{basketId}")
	public ResponseEntity<BigDecimal> getBasketTotalPrice(@PathVariable Integer basketId) {
		BigDecimal totalAmount = basketService.getBasketItemsTotalPrice(basketId);
		
		return new ResponseEntity<>(totalAmount ,HttpStatus.OK);		
	}
	
}

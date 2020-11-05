package com.gofluent.basket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gofluent.basket.dto.AddItemRequestDto;
import com.gofluent.basket.model.Item;
import com.gofluent.basket.service.ItemService;

@RestController
public class ItemController extends ErrorHandlingController{

	private ItemService itemService;

	@Autowired
	public ItemController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}	
	
	@PostMapping(value = "/add-item")
	public ResponseEntity<String> addItem(@RequestBody AddItemRequestDto req) {
		itemService.addItem(new Item(req.getItemName(), req.getPrice()));
		
		return new ResponseEntity<>("Successful!", HttpStatus.OK);
	}
	
}

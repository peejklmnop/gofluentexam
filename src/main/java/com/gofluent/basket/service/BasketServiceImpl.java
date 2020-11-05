package com.gofluent.basket.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gofluent.basket.dto.AddItemToBasketRequestDto;
import com.gofluent.basket.dto.BasketItemDto;
import com.gofluent.basket.dto.GetBasketItemListResponseDto;
import com.gofluent.basket.dto.ItemAndQuantityDto;
import com.gofluent.basket.dto.RemoveItemFromBasketRequestDto;
import com.gofluent.basket.exception.EntityNotFoundException;
import com.gofluent.basket.model.Basket;
import com.gofluent.basket.model.BasketItem;
import com.gofluent.basket.model.Item;
import com.gofluent.basket.repository.BasketRepository;

@Service
public class BasketServiceImpl implements BasketService {
	
	private BasketItemService basketItemService;
	private BasketRepository basketRepository;
	private ItemService itemService;

	@Autowired	
	public BasketServiceImpl(BasketItemService basketItemService, BasketRepository basketRepository,
			ItemService itemService) {
		super();
		this.basketItemService = basketItemService;
		this.basketRepository = basketRepository;
		this.itemService = itemService;
	}

	@Override
	public Basket createBasket(List<BasketItem> itemList) {
		return basketRepository.save(new Basket(itemList));
	}
	
	@Override
	public GetBasketItemListResponseDto addItemToBasket(AddItemToBasketRequestDto req) {
		Basket basket = getBasketFromId(req.getBasketId());		
		List<BasketItem> basketItemList = basket.getBasketItemList();
		
		for (ItemAndQuantityDto itemAndQuantity : req.getItemAndQuantityList()) {
		
			Item item = itemService.getItemFromId(itemAndQuantity.getItemId());
			
			checkAndAddItemsInBasket(basketItemList, item, itemAndQuantity.getQuantity());				
		}
		
		basket.setBasketItemList(basketItemList);
		basketRepository.save(basket);	
		List<BasketItemDto> basketItemListDto = basketItemService.convertBasketItemListToDto(basketItemList);
		
		return new GetBasketItemListResponseDto(basketItemListDto);
	}
	
	
	@Override
	public Basket getBasketFromId(Integer id) {
		Optional<Basket> optionalBasket = basketRepository.findById(id);
		
		if(!optionalBasket.isPresent()) {
			throw new EntityNotFoundException("Basket Id does not exist!");
		}
		
		return optionalBasket.get();
	}
	
	@Override
	public GetBasketItemListResponseDto getBasketItemList(Integer basketId) {
		Basket basket = getBasketFromId(basketId);		
		List<BasketItemDto> basketItemListDto = basketItemService.convertBasketItemListToDto(basket.getBasketItemList());
		
		return new GetBasketItemListResponseDto(basketItemListDto);
	}
	
	
	private void checkAndAddItemsInBasket(List<BasketItem> basketItemList, Item item, Integer quantity) {
		
		Optional<BasketItem> optionalBasketItem = basketItemList.stream().filter( bItem -> bItem.getItem().getId().equals(item.getId())).findAny();
		if (optionalBasketItem.isPresent()) {
			BasketItem existingBasketItem = optionalBasketItem.get();
			Integer newQuantity = existingBasketItem.getQuantity() + quantity;
			basketItemList.removeIf(bItem -> bItem.getItem().getId().equals(item.getId()));
			existingBasketItem.setQuantity(newQuantity);
			basketItemList.add(existingBasketItem);
		} else {
			BasketItem newBasketItem = new BasketItem(quantity, item);
			newBasketItem = basketItemService.addBasketItem(newBasketItem);
			
			basketItemList.add(newBasketItem);
		}			
		
	}
	
	@Override
	public GetBasketItemListResponseDto removeItemFromBasket(RemoveItemFromBasketRequestDto req) {
		
		Basket basket = getBasketFromId(req.getBasketId());		
		List<BasketItem> basketItemList = basket.getBasketItemList();
		
		for (ItemAndQuantityDto itemAndQuantity : req.getItemAndQuantityList()) {
		
			Item item = itemService.getItemFromId(itemAndQuantity.getItemId());
			
			checkAndRemoveItemsFromBasket(basketItemList, item, itemAndQuantity.getQuantity());				
		}
		
		basket.setBasketItemList(basketItemList);
		basketRepository.save(basket);	
		List<BasketItemDto> basketItemListDto = basketItemService.convertBasketItemListToDto(basketItemList);
		
		return new GetBasketItemListResponseDto(basketItemListDto);
		
	}
	
	private void checkAndRemoveItemsFromBasket(List<BasketItem> basketItemList, Item item, Integer quantity) {
		
		Optional<BasketItem> optionalBasketItem = basketItemList.stream().filter( bItem -> bItem.getItem().getId().equals(item.getId())).findAny();
		if (optionalBasketItem.isPresent()) {
			BasketItem existingBasketItem = optionalBasketItem.get();
			Integer newQuantity = existingBasketItem.getQuantity() - quantity;
			basketItemList.removeIf(bItem -> bItem.getItem().getId().equals(item.getId()));
			
			if (newQuantity > 0) {
				existingBasketItem.setQuantity(newQuantity);
				basketItemList.add(existingBasketItem);
			} else {
				basketItemService.delete(existingBasketItem);
			}
		} 			
	}
	
	@Override
	public BigDecimal getBasketItemsTotalPrice(Integer basketId) {
		Basket basket = getBasketFromId(basketId);		
		
		List<BasketItem> basketItemList = basket.getBasketItemList();
		
		BigDecimal totalAmount = BigDecimal.valueOf(0.0);
		for (BasketItem bItem : basketItemList) {
			
			BigDecimal itemPrice = bItem.getItem().getPrice();
			BigDecimal quantity = BigDecimal.valueOf(bItem.getQuantity());
			
			totalAmount = totalAmount.add(itemPrice.multiply(quantity));
		}
		
		return totalAmount;		
	}
	
	
}

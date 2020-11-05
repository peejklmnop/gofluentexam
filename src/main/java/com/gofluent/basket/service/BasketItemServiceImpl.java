package com.gofluent.basket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gofluent.basket.dto.BasketItemDto;
import com.gofluent.basket.model.BasketItem;
import com.gofluent.basket.model.Item;
import com.gofluent.basket.repository.BasketItemRepository;

@Service
public class BasketItemServiceImpl implements BasketItemService {
	
	private BasketItemRepository basketItemRepository;

	@Autowired
	public BasketItemServiceImpl(BasketItemRepository basketItemRepository) {
		super();
		this.basketItemRepository = basketItemRepository;
	}
	
	
	@Override
	public BasketItem addBasketItem(BasketItem basketItem) {
		return basketItemRepository.save(basketItem);
	}
	
	@Override
	public List<BasketItemDto> convertBasketItemListToDto(List<BasketItem> basketItemList) {
		
		List<BasketItemDto> basketItemDtoList = new ArrayList<>();
		for(BasketItem bItem : basketItemList) {
			Item item = bItem.getItem();
			basketItemDtoList.add(new BasketItemDto(item.getName(), item.getPrice(), bItem.getQuantity()));
		}
		
		return basketItemDtoList;
	}
	
	@Override
	public void delete(BasketItem et) {
		basketItemRepository.delete(et);
	}

}

package com.gofluent.basket.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gofluent.basket.model.Item;
import com.gofluent.basket.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	
	private ItemRepository itemRepository;

	
	@Autowired
	public ItemServiceImpl(ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
	}
	
	@Override
	public Item addItem(Item newItem) {
		return itemRepository.save(newItem);
	}	
	
	@Override
	public Item getItemFromId(Integer id) {
		Optional<Item> optionalItem = itemRepository.findById(id);
		
		if(!optionalItem.isPresent()) {
			throw new EntityNotFoundException("Item Id does not exist!");
		}
		
		return optionalItem.get();
	}

}

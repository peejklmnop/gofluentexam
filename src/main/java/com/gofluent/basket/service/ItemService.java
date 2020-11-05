package com.gofluent.basket.service;

import com.gofluent.basket.model.Item;

public interface ItemService {	

	public Item addItem(Item newItem);

	public Item getItemFromId(Integer id);

}

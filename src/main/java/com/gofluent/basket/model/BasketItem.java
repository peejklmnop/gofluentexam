package com.gofluent.basket.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tbl_basket_item")
public class BasketItem extends AbstractIntegerBaseEntity {
	
	@NotNull
	private Integer quantity;
	
	@NotNull
	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToOne(cascade = { CascadeType.DETACH }, fetch = FetchType.LAZY)
	private Item item;	

	public BasketItem(Integer quantity, Item item) {
		super();
		this.quantity = quantity;
		this.item = item;
	}
	
	public BasketItem() {
		
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}

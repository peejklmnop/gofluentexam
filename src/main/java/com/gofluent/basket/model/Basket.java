package com.gofluent.basket.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="tbl_basket")
public class Basket extends AbstractIntegerBaseEntity {
	
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH }, fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_basket_basket_item", joinColumns = @JoinColumn(name = "basket_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "basket_item", referencedColumnName = "id"))
	List<BasketItem> basketItemList;

	public Basket(List<BasketItem> basketItemList) {
		super();
		this.basketItemList = basketItemList;
	}
	
	public Basket() {
		
	}

	public List<BasketItem> getBasketItemList() {
		return basketItemList;
	}

	public void setBasketItemList(List<BasketItem> basketItemList) {
		this.basketItemList = basketItemList;
	}
	
}

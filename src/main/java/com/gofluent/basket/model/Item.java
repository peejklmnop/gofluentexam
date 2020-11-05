package com.gofluent.basket.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tbl_item")
public class Item extends AbstractIntegerBaseEntity {

	@NotNull
	@Column (length = 100)
	private String name;
	
	@NotNull
	private BigDecimal price;
	
	public Item(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public Item() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}		
	
	
}

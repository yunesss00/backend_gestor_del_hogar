package com.uco.tfg.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoppinglistproducts")
public class ShoppingListProduct {
	@Id 
	@Column(name = "productId")
	private Long productId;
	@Id 
	@Column(name = "listId")
	private Long listId;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getListId() {
		return listId;
	}
	public void setListId(Long listId) {
		this.listId = listId;
	}
	
	

}

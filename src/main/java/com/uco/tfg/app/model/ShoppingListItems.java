package com.uco.tfg.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoppingListItems")
public class ShoppingListItems {

	@Column(name = "listId")
	private Long listId;
	
	@Column(name = "productId")
	private Long productId;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@Column(name = "linePrice", nullable = false)
	private float linePrice;

	public Long getListId() {
		return listId;
	}

	public void setListId(Long listId) {
		this.listId = listId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getLinePrice() {
		return linePrice;
	}

	public void setLinePrice(float linePrice) {
		this.linePrice = linePrice;
	}
	
	
}

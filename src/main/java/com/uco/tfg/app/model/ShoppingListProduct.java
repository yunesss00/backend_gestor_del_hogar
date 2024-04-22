package com.uco.tfg.app.model;

import java.util.Objects;

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
	
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        ShoppingListProduct that = (ShoppingListProduct) o;
	        return Objects.equals(productId, that.productId) &&
	               Objects.equals(listId, that.listId);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(productId, listId);
	    }
	

}

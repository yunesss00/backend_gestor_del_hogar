package com.uco.tfg.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoppingListParticipants")
public class ShoppingListParticipants {
	
	@Column(name = "listId")
	private Long listId;

    // Constructor, getters y setters (si es necesario)
	
	public Long getId() {
		return listId;
	}

	public void setId(Long listId) {
		this.listId = listId;
	    }
}

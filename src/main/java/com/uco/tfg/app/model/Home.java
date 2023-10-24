package com.uco.tfg.app.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "homes")
public class Home {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "homes_seq")
	@SequenceGenerator(name = "homes_seq", sequenceName = "homes_seq", allocationSize = 1)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "creator")
	private Long creator;
	
	@ManyToMany(mappedBy = "lstHomes")
	private List<User> lstUsers;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "home" , cascade = CascadeType.ALL)
	private List<ShoppingList> lstShoppingList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}
	
}

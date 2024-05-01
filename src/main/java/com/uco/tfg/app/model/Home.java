package com.uco.tfg.app.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	@Column(name = "description")
	private String description;
	
	@ManyToMany(mappedBy = "lstHomes")
	private List<User> lstUsers;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(
				name = "shoppingLists", joinColumns = @JoinColumn(name = "homeId", referencedColumnName = "id"),
				inverseJoinColumns =  @JoinColumn(name = "id", referencedColumnName = "id")
	)	
	private List<ShoppingList> lstShoppingList;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(
				name = "tasks", joinColumns = @JoinColumn(name = "homeId", referencedColumnName = "id"),
				inverseJoinColumns =  @JoinColumn(name = "id", referencedColumnName = "id")
	)
	private List<Task> lstTasks;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getLstUsers() {
		return lstUsers;
	}

	public void setLstUsers(List<User> lstUsers) {
		this.lstUsers = lstUsers;
	}

	public List<ShoppingList> getLstShoppingList() {
		return lstShoppingList;
	}

	public void setLstShoppingList(List<ShoppingList> lstShoppingList) {
		this.lstShoppingList = lstShoppingList;
	}

	public List<Task> getLstTasks() {
		return lstTasks;
	}

	public void setLstTasks(List<Task> lstTasks) {
		this.lstTasks = lstTasks;
	}

	
}

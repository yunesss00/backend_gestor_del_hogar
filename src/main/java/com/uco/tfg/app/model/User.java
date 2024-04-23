package com.uco.tfg.app.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
	@SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
	private Long id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname1")
	private String lastName1;

	@Column(name = "lastname2")
	private String lastName2;

	@Column(name = "email")
	private String email;

	@Column(name = "photo")
	private String photo;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(
				name = "homeParticipants", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"),
				inverseJoinColumns =  @JoinColumn(name = "homeId", referencedColumnName = "id")
	)
	private List<Home> lstHomes;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(
				name = "itineraryAssignments", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"),
				inverseJoinColumns =  @JoinColumn(name = "itineraryId", referencedColumnName = "id")
	)
	private List<Itinerary> lstItineraries;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(
				name = "assignedTasks", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"),
				inverseJoinColumns =  @JoinColumn(name = "taskId", referencedColumnName = "id")
	)
	private List<Task> lstTasks;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
				name = "shoppingListParticipants", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"),
				inverseJoinColumns =  @JoinColumn(name = "listId", referencedColumnName = "id")
	)
	private List<ShoppingList> lstShoppingLists;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName1() {
		return lastName1;
	}
	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}
	public String getLastName2() {
		return lastName2;
	}
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public List<Itinerary> getLstItineraries() {
		return lstItineraries;
	}
	public void setLstItineraries(List<Itinerary> lstItineraries) {
		this.lstItineraries = lstItineraries;
	}
	public List<Task> getLstTasks() {
		return lstTasks;
	}
	public void setLstTasks(List<Task> lstTasks) {
		this.lstTasks = lstTasks;
	}
	public List<ShoppingList> getLstShoppingLists() {
		return lstShoppingLists;
	}
	public void setLstShoppingLists(List<ShoppingList> lstShoppingLists) {
		this.lstShoppingLists = lstShoppingLists;
	}
	
	
}
package com.uco.tfg.app.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "itineraries")
public class Itinerary {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itineraries_seq")
	@SequenceGenerator(name = "itineraries_seq", sequenceName = "itineraries_seq", allocationSize = 1)
	private Long id;

	@Column(name = "homeId")
	private Long homeId;

	@Column(name = "name", nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "lstItineraries")
	private List<User> lstUsers;
	
	@ManyToMany(mappedBy = "lstItineraries")
	private List<Task> lstTasks;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHomeId() {
		return homeId;
	}

	public void setHomeId(Long homeId) {
		this.homeId = homeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getLstUsers() {
		return lstUsers;
	}

	public void setLstUsers(List<User> lstUsers) {
		this.lstUsers = lstUsers;
	}

	public List<Task> getLstTasks() {
		return lstTasks;
	}

	public void setLstTasks(List<Task> lstTasks) {
		this.lstTasks = lstTasks;
	}
	
	
}
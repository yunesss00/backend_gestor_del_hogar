package com.uco.tfg.app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "itineraries")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Itinerary {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itineraries_seq")
	@SequenceGenerator(name = "itineraries_seq", sequenceName = "itineraries_seq", allocationSize = 1)
	private Long id;

	@Column(name = "homeId")
	private Long homeId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description")
	private String description;
	
	@ManyToMany(mappedBy = "lstItineraries")
	private List<User> lstUsers;
	
	@OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
    private List<ItineraryTasks> lstItineraryTasks;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ItineraryTasks> getLstItineraryTasks() {
		return lstItineraryTasks;
	}

	public void setLstItineraryTasks(List<ItineraryTasks> lstItineraryTasks) {
		this.lstItineraryTasks = lstItineraryTasks;
	}
	
	
}
package com.uco.tfg.app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "itineraryTasks")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ItineraryTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "dayOfWeek")
    private int dayOfWeek;
    
    @Column(name = "deleted")
    private int deleleted;
    
    @ManyToMany
    @JoinTable(
        name = "itineraryTasks",
        joinColumns = @JoinColumn(name = "taskId"),
        inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Task> lstTasks;
    
    @ManyToOne
    @JoinColumn(name = "itineraryId")
    @JsonBackReference
    private Itinerary itinerary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public int getDeleleted() {
		return deleleted;
	}

	public void setDeleleted(int deleleted) {
		this.deleleted = deleleted;
	}

	public List<Task> getLstTasks() {
		return lstTasks;
	}

	public void setLstTasks(List<Task> lstTasks) {
		this.lstTasks = lstTasks;
	}

	public Itinerary getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
    
    
    


}

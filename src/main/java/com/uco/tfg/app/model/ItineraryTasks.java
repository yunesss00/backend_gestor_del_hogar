package com.uco.tfg.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "itineraryTasks")
public class ItineraryTasks {
	
	@Column(name = "itineraryId")
	private Long itineraryId;

    @Column(name = "dayOfWeek", nullable = false)
    private int dayOfWeek;

    @Column(name = "deleted", nullable = false)
    private int deleted;

    // Constructor, getters y setters (si es necesario)

    public Long getId() {
        return itineraryId;
    }

    public void setId(Long itineraryId) {
        this.itineraryId = itineraryId;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}

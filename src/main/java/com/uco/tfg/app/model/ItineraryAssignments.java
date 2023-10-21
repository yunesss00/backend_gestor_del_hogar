package com.uco.tfg.app.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "itineraryTasks")
public class ItineraryAssignments {
	
	@Column(name = "itineraryId")
	private Long itineraryId;
	
	@Column(name = "userId")
	private Long userId;

    @Column(name = "startWeekDate")
    private Date startWeekDate;
    
    @Column(name = "endWeekDate")
    private Date endWeekDate;

    @Column(name = "deleted", nullable = false)
    private int deleted;

    // Constructor, getters y setters (si es necesario)

    public Long getId() {
        return itineraryId;
    }

    public void setId(Long itineraryId) {
        this.itineraryId = itineraryId;
    }

    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getStartWeekDate() {
		return startWeekDate;
	}

	public void setStartWeekDate(Date startWeekDate) {
		this.startWeekDate = startWeekDate;
	}

	public Date getEndWeekDate() {
		return endWeekDate;
	}

	public void setEndWeekDate(Date endWeekDate) {
		this.endWeekDate = endWeekDate;
	}

	public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}

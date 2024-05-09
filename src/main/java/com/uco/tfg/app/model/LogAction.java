package com.uco.tfg.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "logHomeActions")
public class LogAction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_seq")
    @SequenceGenerator(name = "log_seq", sequenceName = "log_seq", allocationSize = 1)
    private Long id;

    @Column(name = "homeId")
    private Long homeId;

    @Column(name = "userId")
    private Long userId;
    
    @Column(name = "user1name")
    private String user1name;

    @Column(name = "actionName") 
    private String actionName;

    @Column(name = "secondUserId")
    private Long secondUserId;
    
    @Column (name = "user2name")
    private String user2name;

    @Column(name = "actionDate")
    private LocalDate actionDate;
    
    @Column(name = "objectName")
    private String objectName;
    
    @Column (name = "description")
    private String description;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public Long getSecondUserId() {
        return secondUserId;
    }

    public void setSecondUserId(Long secondUserId) {
        this.secondUserId = secondUserId;
    }

    public LocalDate getActionDate() {
        return actionDate;
    }

    public void setActionDate(LocalDate actionDate) {
        this.actionDate = actionDate;
    }

	public String getUser1name() {
		return user1name;
	}

	public void setUser1name(String user1name) {
		this.user1name = user1name;
	}

	public String getUser2name() {
		return user2name;
	}

	public void setUser2name(String user2name) {
		this.user2name = user2name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
    
    
}

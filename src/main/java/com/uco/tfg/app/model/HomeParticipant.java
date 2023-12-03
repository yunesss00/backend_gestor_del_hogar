package com.uco.tfg.app.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "homeParticipants")
public class HomeParticipant {

	@Id
    @Column(name = "userid")
    private Long userId;

	@Id
    @Column(name = "homeid")
    private Long homeId;

    @Column(name = "deleted", nullable = false)
    private int deleted;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long user) {
        this.userId = user;
    }

    public Long getHomeId() {
        return homeId;
    }

    public void setHomeId(Long home) {
        this.homeId = home;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}

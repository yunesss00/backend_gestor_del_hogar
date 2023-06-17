package com.uco.tfg.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_seq")
	@SequenceGenerator(name = "tasks_seq", sequenceName = "tasks_seq", allocationSize = 1)
	private Long id;

	@Column(name = "homeId")
	private Long homeId;

	@Column(name = "name")
	private String name;

	@Column(name = "creator")
	private Long creator;

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
	public Long getCreator() {
		return creator;
	}
	public void setCreator(Long creator) {
		this.creator = creator;
	}
}
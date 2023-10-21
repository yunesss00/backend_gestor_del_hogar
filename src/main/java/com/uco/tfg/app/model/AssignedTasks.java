package com.uco.tfg.app.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "assignedTasks")
public class AssignedTasks {

	@Column(name = "taskId")
	private Long taskId;

	@Column(name = "userId")
	private Long userId;
	
	@Column(name = "date")
	private Date date;

	@Column(name = "dayOfWeek", nullable = false)
	private int dayOfWeek;

	@Column(name = "priority", nullable = false)
	private int priority;

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
	
}

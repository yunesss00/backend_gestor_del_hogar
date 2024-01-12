package com.uco.tfg.app.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uco.tfg.app.model.AssignedTask;
import com.uco.tfg.app.model.Task;
import com.uco.tfg.app.repository.AssignedTaskRepository;
import com.uco.tfg.app.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private AssignedTaskRepository assignedTaskRepository;

	public Task create(Task task) {
		return taskRepository.save(task);
	}

	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	public void delete(Task task) {
		taskRepository.delete(task);
	}

	public Optional<Task> findById(Long id) {
		return taskRepository.findById(id);
	}
	
	public List<AssignedTask> findByHomeIdAndDate(Long homeId, LocalDate date) {
		return assignedTaskRepository.findByHomeIdAndDate(homeId,date);
	}
}

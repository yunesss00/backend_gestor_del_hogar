package com.uco.tfg.app.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uco.tfg.app.model.Task;
import com.uco.tfg.app.service.TaskService;

@RestController
@RequestMapping ("api/task")
public class TaskREST {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Task> save(@RequestBody Task task){
		Task temp = taskService.create(task);
		
		try {
			return ResponseEntity.created(new URI("/api/task"+temp.getId())).body(temp);
		
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping 
	private ResponseEntity<List<Task>> getAllTasks(){
		return ResponseEntity.ok(taskService.getAllTasks());
	}
	
	@DeleteMapping 
	private ResponseEntity<Void> deleteTask(@RequestBody Task task){
		taskService.delete(task);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Task>> getTaskById(@PathVariable ("id") Long id){
		return ResponseEntity.ok(taskService.findById(id));
	}
	
}

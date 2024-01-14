package com.uco.tfg.app.rest;

import java.net.URI;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uco.tfg.app.model.AssignedTask;
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
	
	@GetMapping("/assigned/home")	
	private ResponseEntity<List<AssignedTask>> getHomeAssignedTasks(
			@RequestParam Long homeId, 
			@RequestParam String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);

		
		return ResponseEntity.ok(taskService.findByHomeIdAndDate(homeId,localDate));
	}
	
	@GetMapping("/assigned/home/myTasks")	
	private ResponseEntity<List<AssignedTask>> getHomeMyAssignedTasks(
			@RequestParam Long homeId, 
			@RequestParam String date,
			@RequestParam Long userId){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);

		
		return ResponseEntity.ok(taskService.findByHomeIdAndDateAndUserId(homeId,localDate,userId));
	}
	
	@GetMapping("/assigned/home/dotList")	
	private ResponseEntity<List<Integer>> getDotListTasks(
			@RequestParam Long homeId, 
			@RequestParam String initDate,
			@RequestParam String endDate){
       /* DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localInitDate = LocalDate.parse(initDate, formatter);
        LocalDate localEndDate = LocalDate.parse(endDate, formatter);
*/
		
		return ResponseEntity.ok(taskService.getDotListTasks(homeId,initDate,endDate));
	}
	
}

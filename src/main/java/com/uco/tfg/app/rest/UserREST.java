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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uco.tfg.app.model.User;
import com.uco.tfg.app.service.UserService;

import ch.qos.logback.core.status.Status;

@RestController
@RequestMapping ("api/user")
public class UserREST {
	
	@Autowired
	private UserService userService;	

	@PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<User> saveUser(@RequestBody User user){	
		User temp = userService.create(user);
		
		try {
			return ResponseEntity.created(new URI("/api/user" + temp.getId())).body(temp);
		
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping 
	private ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUser());
	}
	
	@DeleteMapping 
	private ResponseEntity<Void> deleteUser(@RequestBody User user){
		userService.delete(user);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<User>> getUserById(@PathVariable ("id") Long id){
		return ResponseEntity.ok(userService.findById(id));
	}
	
	@GetMapping ("/find")
	private ResponseEntity<?> getUserByEmail(@RequestParam String email){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.findByEmail(email));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("error:" + e.getMessage() ));
		}
	}
	
	@GetMapping("/participants/{homeId}")
    private ResponseEntity<List<User>> getHomeParticipants(@PathVariable Long homeId) {
		return ResponseEntity.ok(userService.getHomeParticipants(homeId));
	}	
	
}

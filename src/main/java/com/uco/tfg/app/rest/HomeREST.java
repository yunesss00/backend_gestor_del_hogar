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

import com.uco.tfg.app.model.Home;
import com.uco.tfg.app.service.HomeService;

@RestController
@RequestMapping ("api/home")
public class HomeREST {
	
	@Autowired
	private HomeService homeService;
	
	@PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Home> saveHome(@RequestBody Home home){
		Home temp = homeService.create(home);
		
		try {
			return ResponseEntity.created(new URI("/api/home"+temp.getId())).body(temp);
		
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping 
	private ResponseEntity<List<Home>> getAllHomes(){
		return ResponseEntity.ok(homeService.getAllHomes());
	}
	
	@DeleteMapping 
	private ResponseEntity<Void> deleteHome(@RequestBody Home home){
		homeService.delete(home);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Home>> getHomeById(@PathVariable ("id") Long id){
		return ResponseEntity.ok(homeService.findById(id));
	}
	
}

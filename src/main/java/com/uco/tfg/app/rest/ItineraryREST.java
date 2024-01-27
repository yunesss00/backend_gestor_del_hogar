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

import com.uco.tfg.app.model.Itinerary;
import com.uco.tfg.app.model.Task;
import com.uco.tfg.app.service.ItineraryService;

@RestController
@RequestMapping("api/itinerary")
public class ItineraryREST {

    @Autowired
    private ItineraryService itineraryService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Itinerary> saveItinerary(@RequestBody Itinerary itinerary) {
        Itinerary temp = itineraryService.create(itinerary);

        try {
            return ResponseEntity.created(new URI("/api/itinerary" + temp.getId())).body(temp);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<Itinerary>> getAllItineraries() {
        return ResponseEntity.ok(itineraryService.getAllItineraries());
    }

    @DeleteMapping
    private ResponseEntity<Void> deleteItinerary(@RequestBody Itinerary itinerary) {
        itineraryService.delete(itinerary);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}")
    private ResponseEntity<Optional<Itinerary>> getItineraryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(itineraryService.findById(id));
    }
    
    @GetMapping("/home/{homeId}")	
	private ResponseEntity<List<Itinerary>> getHomeItineraries(@PathVariable Long homeId){
		
		return ResponseEntity.ok(itineraryService.getHomeItineraries(homeId));
	}

}

package com.uco.tfg.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uco.tfg.app.model.Itinerary;
import com.uco.tfg.app.repository.ItineraryRepository;

@Service
public class ItineraryService {

	@Autowired
	private ItineraryRepository itineraryRepository;

	public Itinerary create(Itinerary itinerary) {
		return itineraryRepository.save(itinerary);
	}

	public List<Itinerary> getAllItineraries() {
		return itineraryRepository.findAll();
	}

	public void delete(Itinerary itinerary) {
		itineraryRepository.delete(itinerary);
	}

	public Optional<Itinerary> findById(Long id) {
		return itineraryRepository.findById(id);
	}

}

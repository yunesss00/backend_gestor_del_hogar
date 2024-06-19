package com.uco.tfg.app.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uco.tfg.app.model.Itinerary;
import com.uco.tfg.app.model.ItineraryTasks;
import com.uco.tfg.app.model.Task;
import com.uco.tfg.app.repository.ItineraryRepository;
import com.uco.tfg.app.repository.ItineraryTaskRepository;

@Service
public class ItineraryService {

	@Autowired
	private ItineraryRepository itineraryRepository;
	@Autowired
	private ItineraryTaskRepository itineraryTasksRepository;
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
	
	public List<Itinerary> getHomeItineraries(Long homeId) {
		return itineraryRepository.findByHomeId(homeId);
	}
	
	public void saveItineraryCustom(Itinerary itinerary) {
		 Random random = new Random();
		Long itineraryId = random.nextLong(99999999 - 00000001 + 1) + 00000001;
		itineraryRepository.saveItineraryCustom( itineraryId, itinerary.getHomeId(), itinerary.getName(), itinerary.getDescription());
		List<ItineraryTasks> tasks = itinerary.getLstItineraryTasks();
		for (ItineraryTasks itTask: tasks) {
			for (Task task :itTask.getLstTasks()) {
				itineraryTasksRepository.saveItineraryTask (itineraryId, task.getId(),itTask.getDayOfWeek(), itTask.getDeleleted());
			}
		}

	}

}

package com.uco.tfg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uco.tfg.app.model.Itinerary;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

}

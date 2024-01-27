package com.uco.tfg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uco.tfg.app.model.Itinerary;
import java.util.List;


@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

	List<Itinerary> findByHomeId(Long homeId);
}

package com.uco.tfg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uco.tfg.app.model.Itinerary;

import jakarta.transaction.Transactional;

import java.util.List;


@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

	List<Itinerary> findByHomeId(Long homeId);
	
	@Transactional
    @Modifying
    @Query (value = "INSERT INTO itineraries (id, homeid, name, description) VALUES (:id,:homeId, :name, :description)", nativeQuery = true)
	void saveItineraryCustom(@Param("id") Long id, 
			@Param("homeId") Long homeId, 
            @Param("name") String name, 
            @Param("description") String description);
	
	
}

package com.uco.tfg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uco.tfg.app.model.ItineraryTasks;

import jakarta.transaction.Transactional;

import java.util.List;


@Repository
public interface ItineraryTaskRepository extends JpaRepository<ItineraryTasks, Long> {

	
	@Transactional
    @Modifying
    @Query (value = "INSERT INTO itineraryTasks (itineraryid, taskid, dayOfWeek, deleted) VALUES (:itineraryId,:taskId, :dayOfWeek, :deleleted)", nativeQuery = true)
	void saveItineraryTask(@Param("itineraryId") Long itineraryId,@Param("taskId") Long taskId,@Param("dayOfWeek") int dayOfWeek,@Param("deleleted") int deleleted);

	
	
}

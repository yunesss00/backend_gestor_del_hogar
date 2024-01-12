package com.uco.tfg.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uco.tfg.app.model.AssignedTask;
import com.uco.tfg.app.model.Task;

public interface AssignedTaskRepository extends JpaRepository<AssignedTask, Long> {

	
	List<AssignedTask> findByHomeIdAndDate(Long homeId, LocalDate date);
}

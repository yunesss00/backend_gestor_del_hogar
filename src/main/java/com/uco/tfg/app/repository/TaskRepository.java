package com.uco.tfg.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uco.tfg.app.model.AssignedTask;
import com.uco.tfg.app.model.Task;

import jakarta.transaction.Transactional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByHomeId(Long homeId);


}

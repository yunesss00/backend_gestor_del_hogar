package com.uco.tfg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uco.tfg.app.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}

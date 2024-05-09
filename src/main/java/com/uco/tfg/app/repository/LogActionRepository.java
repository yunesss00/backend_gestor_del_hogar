package com.uco.tfg.app.repository;

import com.uco.tfg.app.model.LogAction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogActionRepository extends JpaRepository<LogAction, Long> {

	List<LogAction> getLogActionByHomeId(Long homeId);
}

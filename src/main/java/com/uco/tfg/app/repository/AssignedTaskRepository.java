package com.uco.tfg.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uco.tfg.app.model.AssignedTask;
import com.uco.tfg.app.model.Task;

public interface AssignedTaskRepository extends JpaRepository<AssignedTask, Long> {

	@Query(value = "SELECT\r\n"
			+ "    CASE\r\n"
			+ "        WHEN COUNT(assignedtasks.id) > 0 THEN 1\r\n"
			+ "        ELSE 0\r\n"
			+ "    END AS has_tasks\r\n"
			+ "FROM\r\n"
			+ "    generate_series(TO_DATE(:INITDATE, 'yyyy-MM-dd'), TO_DATE(:ENDDATE, 'yyyy-MM-dd'), interval '1 day' ) generate_series\r\n"
			+ "CROSS JOIN (\r\n"
			+ "    SELECT DISTINCT homeId FROM assignedtasks WHERE homeId = :HOME AND done = 0\r\n"
			+ ") homeIds\r\n"
			+ "LEFT JOIN assignedtasks ON\r\n"
			+ "    assignedtasks.date = generate_series\r\n"
			+ "    AND assignedtasks.homeId = homeIds.homeId\r\n"
			+ "GROUP BY\r\n"
			+ "    generate_series,\r\n"
			+ "    homeIds.homeId\r\n"
			+ "ORDER BY\r\n"
			+ "    generate_series,\r\n"
			+ "    homeIds.homeId;\r\n"
			+ "", 
			nativeQuery = true)
	List<Integer> getDotListTasks(@Param("HOME") Long home,@Param("INITDATE") String initDate, @Param("ENDDATE") String endDate);
	
	List<AssignedTask> findByHomeIdAndDate(Long homeId, LocalDate date);
	List<AssignedTask> findByHomeIdAndDateAndUserId(Long homeId, LocalDate date, Long userId );

}

package com.uco.tfg.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uco.tfg.app.model.AssignedTask;
import com.uco.tfg.app.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	/*@Query(value = "select "
			+ "t.id,"
			+ "t.userId"
			+ " from tasks t\r\n"
			+ "join assignedtasks a on t.id = a.taskid \r\n"
			+ "where t.homeid = :HOME "
			+ "and a.date = TO_DATE(:DATE, 'YYYY-MM-DD')", 
			nativeQuery = true)
	List<AssignedTaskDTO> getHomeAssignedTasks (@Param("HOME")  Long home,@Param("DATE")  String date);
	*/
	//List<AssignedTask> findByHomeIdAndDate(Long homeId, String date);

}

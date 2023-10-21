package com.uco.tfg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uco.tfg.app.model.Home;
import com.uco.tfg.app.model.HomeParticipant;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

	@Query(value = "insert into homeparticipants (homeid,userid,deleted)\r\n"
			+ "values(:USER, :HOME,0)", 
			nativeQuery = true)
	HomeParticipant addParticipant(@Param("USER") Long user,@Param("HOME") Long home);
	
	@Query(value = "select h.id, h.name, h.creator from homes h\r\n"
			+ "join homeparticipants hp\r\n"
			+ "	on hp.homeid = h.id\r\n"
			+ "where hp.userid = :USER", 
			nativeQuery = true)
	Home findMyHome (@Param("USER")  Long user);
}

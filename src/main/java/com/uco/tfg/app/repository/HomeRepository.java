package com.uco.tfg.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uco.tfg.app.model.Home;
import com.uco.tfg.app.model.User;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

	@Query(value = "insert into homeparticipants (userid,homeid,deleted)\r\n"
			+ "values(:USER, :HOME,0)", 
			nativeQuery = true)
	boolean addParticipant(@Param("USER") Long user,@Param("HOME") Long home);
	
	@Query(value = "select h.id, h.name, h.creator, h.description from homes h\r\n"
			+ "join homeparticipants hp\r\n"
			+ "	on hp.homeid = h.id\r\n"
			+ "where hp.userid = :USER", 
			nativeQuery = true)
	Home findMyHome (@Param("USER")  Long user);
	
	@Query(value ="SELECT u.* FROM users u "
    		+ "join homeparticipants p on p.userid = u.id "
    		+ "WHERE p.homeid = :id AND p.deleted = 0", nativeQuery = true)
	List<User> getHomeParticipants(Long id);
}

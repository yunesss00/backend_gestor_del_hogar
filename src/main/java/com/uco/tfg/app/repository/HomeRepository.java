package com.uco.tfg.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uco.tfg.app.model.Home;
import com.uco.tfg.app.model.User;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

	@Modifying
	@Query(value = "insert into homeparticipants (userid,homeid,deleted)\r\n"
			+ "values(:USER, :HOME,0)", 
			nativeQuery = true)
	int addParticipant(@Param("USER") Long user,@Param("HOME") Long home);
	
	@Query(value = "select h.id, h.name, h.creator, h.description from homes h\r\n"
			+ "			join homeparticipants hp\r\n"
			+ "			on hp.homeid = h.id\r\n"
			+ "			and hp.deleted =0\r\n"
			+ "			join currentHome ch \r\n"
			+ "			on ch.userId = hp.userid \r\n"
			+ "			and ch.homeId = hp.homeid \r\n"
			+ "			where hp.userid = :USER", 
			nativeQuery = true)
	Home findMyHome (@Param("USER")  Long user);
	
	@Modifying
	@Query(value = "insert into currentHome (userid,homeid) values(:USER, :HOME)"
			+ "ON CONFLICT (userId) DO UPDATE SET homeId = EXCLUDED.homeId", 
			nativeQuery = true)
	void setCurrentHome(@Param("USER") Long user,@Param("HOME") Long home);
	
	@Query(value ="SELECT u.* FROM users u "
    		+ "join homeparticipants p on p.userid = u.id "
    		+ "WHERE p.homeid = :id AND p.deleted = 0", nativeQuery = true)
	List<User> getHomeParticipants(Long id);

	@Modifying
	@Query(value ="insert into homeInvitations ( guestEmail,homeId, inviterId, accepted)\r\n"
			+ "values(:email,:homeId, :userId, 0)", nativeQuery = true)
	boolean inviteUser(String email, Long homeId, Long userId);

	@Modifying
	@Query(value ="update homeInvitations set accepted = :accepted where homeId = :homeId and guestEmail = :email",
	nativeQuery = true)
	int updateInvitation(String email, Long homeId, int accepted);

	@Query(value ="select homeId from homeInvitations where guestEmail = :email and accepted !=1", nativeQuery = true)
	List<Long> getInvitations(String email);

	@Query(value = "select h.id, h.name, h.creator, h.description from homes h\r\n"
			+ "			join homeparticipants hp\r\n"
			+ "			on hp.homeid = h.id\r\n"
			+ "			and hp.deleted =0\r\n"
			+ "			where hp.userid = :userId", 
			nativeQuery = true)
	List<Home> findMyHomes(Long userId);
}

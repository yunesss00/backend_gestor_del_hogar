package com.uco.tfg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uco.tfg.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "select id, firstname, lastname1, lastname2, email, photo from users u where email like %:EMAIL%", nativeQuery = true)
	User findByEmail(@Param("EMAIL") String email);

}

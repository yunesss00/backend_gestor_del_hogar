package com.uco.tfg.app.repository;

import com.uco.tfg.app.model.ShoppingList;
import com.uco.tfg.app.model.ShoppingListParticipant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

	
	List<ShoppingList> findByLstHomesId(Long homeId);

	@Query(value = "insert into shoppinglistparticipants (listid, userid)"
			+ "values(:listId,:userId)", 
			nativeQuery = true)
	ShoppingListParticipant assignParticipants(Long userId, Long listId);



}
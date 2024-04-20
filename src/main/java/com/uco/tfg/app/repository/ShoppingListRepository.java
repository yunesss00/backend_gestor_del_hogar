package com.uco.tfg.app.repository;

import com.uco.tfg.app.model.ShoppingList;
import com.uco.tfg.app.model.ShoppingListParticipant;
import com.uco.tfg.app.model.ShoppingListProduct;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

	
	List<ShoppingList> findByLstHomesId(Long homeId);

	@Query(value = "insert into shoppinglistparticipants (listid, userid)"
			+ "values(:listId,:userId)", 
			nativeQuery = true)
	ShoppingListParticipant assignParticipants(Long userId, Long listId);

	@Query(value = "select distinct category from products", 
			nativeQuery = true)
	List<String> getCategories();

	@Modifying
	@Query(value = "insert into shoppinglistproducts (listid, productid) "
			+ "values(:shoppingListId,:productId)", 
			nativeQuery = true)
	int addShoppingListProduct(Long productId, Long shoppingListId);

	@Modifying
	@Query(value = "delete from shoppinglistproducts where listId = :listId", 
			nativeQuery = true)
	void deleteProducts(Long listId);

	


}
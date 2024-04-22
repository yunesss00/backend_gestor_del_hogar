package com.uco.tfg.app.repository;

import com.uco.tfg.app.model.ShoppingList;
import com.uco.tfg.app.model.ShoppingListProduct;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

	
	
	@Query(value = "select lsl1_0.homeId, lsl1_0.id, lsl1_0.homeId, lsl1_0.homeShoppingList, lsl1_0.name, lsl1_0.totalPrice, lsl1_0.userId\r\n"
			+ "from shoppingLists lsl1_0\r\n"
			+ "join shoppinglistparticipants slp on slp.listid = lsl1_0.id  and slp.userid = :userId\r\n"
			+ "where lsl1_0.homeId = :homeId and slp.selected =1", 
			nativeQuery = true)
	List<ShoppingList> findMyShoppingLists(Long homeId, Long userId);
	
	@Modifying
	@Query(value = "INSERT INTO shoppinglistparticipants (listid, userid, selected)\r\n"
			+ "VALUES (:listId, :userId, :selected)\r\n"
			+ "ON CONFLICT (listid, userid) DO UPDATE SET selected = EXCLUDED.selected", 
			nativeQuery = true)
	int assignParticipants(Long userId, Long listId, int selected);

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

	@Query(value = "select userId from shoppinglistparticipants where listId = :id and selected = 1", 
			nativeQuery = true)
	Optional<List<Integer>> getShoppingListParticipants(Long id);

	


}
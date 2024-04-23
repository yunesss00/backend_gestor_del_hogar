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

	
	
	@Query(value = "SELECT \r\n"
			+ "    lsl1_0.homeId,\r\n"
			+ "    lsl1_0.id,\r\n"
			+ "    lsl1_0.homeShoppingList,\r\n"
			+ "    lsl1_0.name,\r\n"
			+ "    lsl1_0.totalPrice,\r\n"
			+ "    lsl1_0.userId\r\n"
			+ "FROM \r\n"
			+ "    shoppingLists lsl1_0\r\n"
			+ "JOIN \r\n"
			+ "    shoppinglistparticipants slp ON slp.listid = lsl1_0.id AND slp.userid = :userId\r\n"
			+ "WHERE \r\n"
			+ "    lsl1_0.homeId = :homeId AND slp.selected = 1", 
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
	
	@Modifying
	@Query(value = "delete from shoppinglistparticipants where listId = :id", 
			nativeQuery = true)
	void participantsDelete(Long id);
	
	@Modifying
	@Query(value = "delete from shoppinglistproducts where listId = :id", 
			nativeQuery = true)
	void productsDelete(Long id);
	
	


}
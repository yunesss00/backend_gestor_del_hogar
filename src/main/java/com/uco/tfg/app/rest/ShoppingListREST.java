package com.uco.tfg.app.rest;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.uco.tfg.app.model.ShoppingList;
import com.uco.tfg.app.service.ShoppingListService;
@RestController
@RequestMapping("api/shoppingList")
public class ShoppingListREST {
    @Autowired
    private ShoppingListService shoppingListService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<ShoppingList> saveShoppingList(@RequestBody ShoppingList shoppingList) {
        ShoppingList temp = shoppingListService.create(shoppingList);
        try {
        	shoppingListService.assignParticipants(shoppingList.getUserId(), shoppingList.getId(), true);
            return ResponseEntity.created(new URI("/api/shoppingList/" + temp.getId())).body(temp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping
    private ResponseEntity<List<ShoppingList>> getAllShoppingLists() {
        return ResponseEntity.ok(shoppingListService.getAllShoppingLists());
    }

    @DeleteMapping
    private ResponseEntity<Void> deleteShoppingList(@RequestBody ShoppingList shoppingList) {
        shoppingListService.delete(shoppingList);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    private ResponseEntity<Optional<ShoppingList>> getShoppingListById(@PathVariable Long id) {
        return ResponseEntity.ok(shoppingListService.findById(id));
    }
/*
    @GetMapping("/user/{userId}")
    private ResponseEntity<?> findShoppingListsByUserId(@PathVariable Long userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(shoppingListService.findShoppingListsByUserId(userId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("error:" + e.getMessage()));
		}
	}*/
    
    @GetMapping("/myHome")
    private ResponseEntity<?> findMyShoppingLists(@RequestParam Long homeId,@RequestParam Long userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(shoppingListService.findMyShoppingLists(homeId, userId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("error:" + e.getMessage()));
		}
	}
    
    @PostMapping("/participants")
    private int assignParticipants(@RequestParam Long userId,@RequestParam Long listId, @RequestParam boolean selected) {
    	return shoppingListService.assignParticipants(userId,listId, selected);
    }
    
    @GetMapping("/categories")
    private List<String> getCategories() {
    	return shoppingListService.getCategories();
    }
    
    @PutMapping("updateProducts")
    private boolean updateShoppingListProducts(@RequestBody ShoppingList shoppingList) {
    	return shoppingListService.updateShoppingListProducts(shoppingList);
    }
    
    @GetMapping("participants/{id}")
    private Optional<List<Integer>> getShoppingListParticipants(@PathVariable Long id) {
        return shoppingListService.getShoppingListParticipants(id);
    }
    
    
}
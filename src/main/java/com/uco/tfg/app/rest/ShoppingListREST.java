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
            return ResponseEntity.created(new URI("/api/shoppingList/" + temp.getId())).body(temp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping
    private ResponseEntity<List<ShoppingList>> getAllShoppingLists() {
        return ResponseEntity.ok(shoppingListService.getAllShoppingLists());
    }
/*
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteShoppingList(@PathVariable Long id) {
        shoppingListService.deleteById(id);
        return ResponseEntity.ok().build();
    }*/
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
    
    @GetMapping("/myHome/{homeId}")
    private ResponseEntity<?> findShoppingListsHomeId(@PathVariable Long homeId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(shoppingListService.findShoppingListsHomeId(homeId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("error:" + e.getMessage()));
		}
	}
    
    @PostMapping("/participants")
    private ResponseEntity<?> assignParticipants(@RequestParam Long userId,@RequestParam Long listId) {
    	try {
    		return ResponseEntity.status(HttpStatus.OK).body(shoppingListService.assignParticipants(userId,listId));
    	}catch (Exception e){
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("error:" + e.getMessage()));
    	}
    }
    
}
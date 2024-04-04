package com.uco.tfg.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uco.tfg.app.model.ShoppingList;
import com.uco.tfg.app.model.ShoppingListParticipant;
import com.uco.tfg.app.repository.ShoppingListRepository;

@Service
public class ShoppingListService {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    public ShoppingList create(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    public List<ShoppingList> getAllShoppingLists() {
        return shoppingListRepository.findAll();
    }

    public void delete(ShoppingList shoppingList) {
        shoppingListRepository.delete(shoppingList);
    }

    public Optional<ShoppingList> findById(Long id) {
        return shoppingListRepository.findById(id);
    }

	public List<ShoppingList> findShoppingListsHomeId(Long homeId) {
		return shoppingListRepository.findByLstHomesId(homeId);
	}

	public ShoppingListParticipant assignParticipants(Long userId, Long listId) {
		return shoppingListRepository.assignParticipants(userId, listId);
	}

}
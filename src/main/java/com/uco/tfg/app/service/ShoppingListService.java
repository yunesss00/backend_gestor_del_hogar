package com.uco.tfg.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uco.tfg.app.model.Product;
import com.uco.tfg.app.model.ShoppingList;
import com.uco.tfg.app.model.ShoppingListProduct;
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
    @Transactional
	public List<ShoppingList> findMyShoppingLists(Long homeId, Long userId) {
		return shoppingListRepository.findMyShoppingLists(homeId,userId);
	}
	@Transactional
	public int assignParticipants(Long userId, Long listId, boolean selected) {
		return shoppingListRepository.assignParticipants(userId, listId,selected ? 1 : 0);
	}

	public List<String> getCategories() {
		return shoppingListRepository.getCategories();

	}

	@Transactional
	public boolean updateShoppingListProducts(ShoppingList shoppingList) {
		
		List<Product> products = shoppingList.getLsProducts();
		int success= 0;
		Optional<ShoppingList> slBefore;
		slBefore = shoppingListRepository.findById(shoppingList.getId());
		if(slBefore.get()!=null && !slBefore.get().getLsProducts().isEmpty()) {
			shoppingListRepository.deleteProducts(shoppingList.getId());
		}
		
		if(!shoppingList.getLsProducts().isEmpty()) {
			for (Product product: shoppingList.getLsProducts()) {
				success =+ shoppingListRepository.addShoppingListProduct(product.getId(), shoppingList.getId());
			}
		}
		
		if (success== shoppingList.getLsProducts().size()) {
			return true;
		}else {
			return false;
		}

		
	}

	public Optional<List<Integer>> getShoppingListParticipants(Long id) {
		return shoppingListRepository.getShoppingListParticipants(id);
	}


}
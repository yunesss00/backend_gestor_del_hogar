package com.uco.tfg.app.repository;

import com.uco.tfg.app.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}
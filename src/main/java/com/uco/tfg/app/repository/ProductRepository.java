package com.uco.tfg.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uco.tfg.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Page<Product> findAll(Pageable pageable);

    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);

	Page<Product> getProductsByCategory(String category, Pageable pageable);

	

}

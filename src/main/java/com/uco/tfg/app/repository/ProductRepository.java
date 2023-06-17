package com.uco.tfg.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uco.tfg.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

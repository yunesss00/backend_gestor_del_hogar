package com.uco.tfg.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.uco.tfg.app.model.Product;
import com.uco.tfg.app.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product create(Product product) {
		return productRepository.save(product);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public void delete(Product product) {
		productRepository.delete(product);
	}

	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}
	
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}


}

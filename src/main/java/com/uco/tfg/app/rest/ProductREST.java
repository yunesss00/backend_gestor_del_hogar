package com.uco.tfg.app.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.uco.tfg.app.model.Product;
import com.uco.tfg.app.service.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductREST {

    @Autowired
    private ProductService productService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product temp = productService.create(product);

        try {
            return ResponseEntity.created(new URI("/api/product" + temp.getId())).body(temp);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @DeleteMapping
    private ResponseEntity<Void> deleteProduct(@RequestBody Product product) {
        productService.delete(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}")
    private ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }
    
    @GetMapping("/search")
    private Page<Product> getProducts(@PageableDefault(size = 20)Pageable pageable){
    	
		return productService.findAll(pageable);
    	
    }
    
    



}

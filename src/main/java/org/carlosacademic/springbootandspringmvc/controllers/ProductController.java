package org.carlosacademic.springbootandspringmvc.controllers;

import org.carlosacademic.springbootandspringmvc.entities.ProductEntity;
import org.carlosacademic.springbootandspringmvc.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> saveProduct(@RequestBody ProductEntity product) {
        productRepository.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

package org.carlosacademic.springbootandspringmvc.controllers;

import org.carlosacademic.springbootandspringmvc.entities.ProductEntity;
import org.carlosacademic.springbootandspringmvc.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    public ResponseEntity<Void> saveProduct(@RequestBody ProductEntity product) {
        productService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/price")
    public ResponseEntity<Void> updatePrice(@PathVariable int id, @RequestBody BigDecimal price) {
        productService.updatePrice(id, price);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

package org.carlosacademic.springbootandspringmvc.services;

import org.carlosacademic.springbootandspringmvc.entities.ProductEntity;
import org.carlosacademic.springbootandspringmvc.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public void saveProduct(ProductEntity product) {
        productRepository.save(product);
    }

    public void updatePrice(int id, BigDecimal price) {
        productRepository.updatePrice(id, price);
    }
}

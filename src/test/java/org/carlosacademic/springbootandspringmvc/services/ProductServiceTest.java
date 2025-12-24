package org.carlosacademic.springbootandspringmvc.services;

import org.carlosacademic.springbootandspringmvc.entities.ProductEntity;
import org.carlosacademic.springbootandspringmvc.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Test
    @DisplayName("Test if the service saves a new product")
    public void testSaveProduct() {
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductService productService = new ProductService(productRepository);

        ProductEntity entity = new ProductEntity();
        entity.setName("Test");
        entity.setPrice(BigDecimal.TEN);

        when(productRepository.save(entity))
                .thenReturn(entity);

        productService.saveProduct(entity);

        verify(productRepository, times(1)).save(entity);
    }

    @Test
    @DisplayName("Test if the service returns all products")
    public void testGetProducts(){
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductService productService = new ProductService(productRepository);

        ProductEntity entity = new ProductEntity();
        entity.setName("Test");
        entity.setPrice(BigDecimal.TEN);

        when(productRepository.findAll()).thenReturn(List.of(entity));

        productService.getAllProducts();

        verify(productRepository, times(1)).findAll();
        verifyNoMoreInteractions(productRepository);
        Assertions.assertEquals(1, productService.getAllProducts().size());
    }
}

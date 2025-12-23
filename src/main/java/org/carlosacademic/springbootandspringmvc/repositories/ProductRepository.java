package org.carlosacademic.springbootandspringmvc.repositories;

import org.carlosacademic.springbootandspringmvc.entities.ProductEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

/**
 * This simply uses the spring data jdbc for demonstrating the usage of the contracts
 *  without using hibernate, the contracts are with spring data, not with hibernate
 *  Spring Data JDBC is a better option for using instead of spring JDBCTemplate.
 */
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

    /**
     * Modifying annotation is required for any query that modifies data.
     */
    @Modifying
    @Query("update products set price = :price where id = :id")
    void updatePrice(int id, BigDecimal price);
}

package org.carlosacademic.springbootandspringmvc.repositories;

import org.carlosacademic.springbootandspringmvc.entities.ProductEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(ProductEntity product) {
        String sql = "INSERT INTO products (name, price) VALUES (?, ?)";
        jdbcTemplate.update(sql, product.getName(), product.getPrice());
    }

    public List<ProductEntity> findAll() {
        String sql = "SELECT * FROM products";
        RowMapper<ProductEntity> productRowMapper = (r , i) -> new ProductEntity(r.getInt("id"), r.getString("name"), r.getBigDecimal("price"));
        return jdbcTemplate.query(sql, productRowMapper);
    }
}

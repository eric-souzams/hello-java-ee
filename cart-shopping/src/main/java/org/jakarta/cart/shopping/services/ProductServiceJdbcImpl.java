package org.jakarta.cart.shopping.services;

import org.jakarta.cart.shopping.exceptions.ServiceJdbcException;
import org.jakarta.cart.shopping.models.Product;
import org.jakarta.cart.shopping.repositories.ProductRepositoryJdbcImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductServiceJdbcImpl implements ProductService {

    private ProductRepositoryJdbcImpl productRepositoryJdbc;

    public ProductServiceJdbcImpl(Connection connection) {
        this.productRepositoryJdbc = new ProductRepositoryJdbcImpl(connection);
    }

    @Override
    public List<Product> list() {
        try {
            return productRepositoryJdbc.listAll();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage());
        }
    }

    @Override
    public Optional<Product> findById(Long id) {
        try {
            return Optional.ofNullable(productRepositoryJdbc.findById(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage());
        }
    }
}

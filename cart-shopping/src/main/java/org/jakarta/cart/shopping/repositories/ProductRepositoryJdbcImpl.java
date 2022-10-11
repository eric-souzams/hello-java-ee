package org.jakarta.cart.shopping.repositories;

import org.jakarta.cart.shopping.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryJdbcImpl implements Repository<Product> {

    private Connection connection;

    public ProductRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Product> listAll() throws SQLException {
        List<Product> products = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT p.*, c.name as category FROM product as p " +
                    " inner join category as c ON (p.category_id = c.id)");

            while (resultSet.next()) {
                Product product = getProduct(resultSet);

                products.add(product);
            }
        }

        return products;
    }


    @Override
    public Product findById(Long id) throws SQLException {
        Product product = null;

        String query = "SELECT p.*, c.name as category FROM product as p " +
                 "inner join category as c ON (p.category_id = c.id) WHERE p.id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    product = getProduct(resultSet);
                }
            }
        }

        return product;
    }

    @Override
    public void save(Product product) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {

    }
    private static Product getProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getLong("id"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getInt("price"));
        product.setType(resultSet.getString("category"));
        return product;
    }
}

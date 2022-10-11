package org.jakarta.cart.shopping.services;


import org.jakarta.cart.shopping.models.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> list() {
        return Arrays.asList(
                new Product(1L,"notebook", "pc", 5000),
                new Product(2L,"smartphone", "cell", 300),
                new Product(3L,"smart-tv", "tv", 200)
        );
    }

    @Override
    public Optional<Product> findById(Long id) {
        return list().stream().filter(p -> p.getId().equals(id)).findAny();
    }
}

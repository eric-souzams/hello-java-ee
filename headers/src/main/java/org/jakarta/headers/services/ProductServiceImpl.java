package org.jakarta.headers.services;

import org.jakarta.headers.models.Product;

import java.util.Arrays;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> list() {
        return Arrays.asList(
                new Product(1L,"notebook", "pc", 5000),
                new Product(2L,"smartphone", "cell", 300),
                new Product(3L,"smart-tv", "tv", 200)
        );
    }
}

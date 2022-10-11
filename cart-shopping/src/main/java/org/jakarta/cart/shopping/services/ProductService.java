package org.jakarta.cart.shopping.services;

import org.jakarta.cart.shopping.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> list();

    Optional<Product> findById(Long id);

}

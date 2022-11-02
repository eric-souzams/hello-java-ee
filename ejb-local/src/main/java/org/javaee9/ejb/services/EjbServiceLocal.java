package org.javaee9.ejb.services;

import jakarta.ejb.Local;
import org.javaee9.ejb.models.Product;

import java.util.List;

@Local
public interface EjbServiceLocal {

    String test();
    List<Product> list();
    Product save(Product product);

}

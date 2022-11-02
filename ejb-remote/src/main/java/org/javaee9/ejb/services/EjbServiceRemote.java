package org.javaee9.ejb.services;

import jakarta.ejb.Remote;
import org.javaee9.ejb.models.Product;

import java.util.List;

@Remote
public interface EjbServiceRemote {

    String test();
    List<Product> list();
    Product save(Product product);

}

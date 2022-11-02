package org.javaee9.ejb.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import org.javaee9.ejb.models.Product;

import java.util.ArrayList;
import java.util.List;

//@ApplicationScoped
@Stateless
public class EjbService implements EjbServiceLocal {

    @PostConstruct
    public void init() {
        System.out.println("Creating a bean: " + this);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying a bean:" + this);
    }

    public String test() {
        return "Test from return";
    }

    @Override
    public List<Product> list() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Rice"));
        products.add(new Product("Bean"));
        products.add(new Product("Potato"));
        return products;
    }

    @Override
    public Product save(Product product) {
        Product product1 = new Product();
        product1.setName(product.getName());

        return product1;
    }
}

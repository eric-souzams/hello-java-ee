package org.javaee9.ejb.models;

import java.io.Serializable;

public class Product implements Serializable {

    static final long serialVersionUID = 4854654541564L;

    private String name;

    public Product() {}

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product = {" +
                "name='" + name + '\'' +
                '}';
    }
}

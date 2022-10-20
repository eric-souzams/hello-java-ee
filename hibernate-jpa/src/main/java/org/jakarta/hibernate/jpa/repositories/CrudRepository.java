package org.jakarta.hibernate.jpa.repositories;

import org.jakarta.hibernate.jpa.model.entity.Client;

import java.util.List;

public interface CrudRepository<T> {

    List<T> findAll();
    T findById(Long id);
    void save(T t);
    void delete(Long id);

}

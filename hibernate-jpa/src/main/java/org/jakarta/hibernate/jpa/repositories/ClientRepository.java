package org.jakarta.hibernate.jpa.repositories;

import jakarta.persistence.EntityManager;
import org.jakarta.hibernate.jpa.model.entity.Client;

import java.util.List;

public class ClientRepository implements CrudRepository<Client> {

    private EntityManager entityManager;

    public ClientRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Client> findAll() {
        return entityManager.createQuery("select c from Client c", Client.class).getResultList();
    }

    @Override
    public Client findById(Long id) {
        return entityManager.find(Client.class, id);
    }

    @Override
    public void save(Client client) {
        if (client.getId() == null && client.getId() > 0) {
            entityManager.merge(client);
        } else {
            entityManager.persist(client);
        }
    }

    @Override
    public void delete(Long id) {
        Client client = findById(id);
        entityManager.remove(client);
    }
}

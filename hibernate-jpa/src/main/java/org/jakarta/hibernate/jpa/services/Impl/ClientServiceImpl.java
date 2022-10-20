package org.jakarta.hibernate.jpa.services.Impl;

import jakarta.persistence.EntityManager;
import org.jakarta.hibernate.jpa.model.entity.Client;
import org.jakarta.hibernate.jpa.repositories.ClientRepository;
import org.jakarta.hibernate.jpa.repositories.CrudRepository;
import org.jakarta.hibernate.jpa.services.ClientService;

import java.util.List;
import java.util.Optional;

public class ClientServiceImpl implements ClientService {

    private EntityManager entityManager;
    private CrudRepository<Client> clientRepository;

    public ClientServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.clientRepository = new ClientRepository(entityManager);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return Optional.ofNullable(clientRepository.findById(id));
    }

    @Override
    public void save(Client client) {
        try {
            entityManager.getTransaction().begin();
            clientRepository.save(client);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            entityManager.getTransaction().begin();
            clientRepository.delete(id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}

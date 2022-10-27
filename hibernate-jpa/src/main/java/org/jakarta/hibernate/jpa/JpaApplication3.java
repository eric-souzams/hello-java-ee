package org.jakarta.hibernate.jpa;

import jakarta.persistence.EntityManager;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jakarta.hibernate.jpa.config.JpaConfig;
import org.jakarta.hibernate.jpa.model.entity.Address;
import org.jakarta.hibernate.jpa.model.entity.Client;
import org.jakarta.hibernate.jpa.model.entity.Invoice;

import java.util.logging.Logger;

public class JpaApplication3 {
    public static void main(String[] args) {
        EntityManager entityManager = JpaConfig.getEntityManager();
        Logger logger = Logger.getLogger(LoggerFactory.logger(JpaApplication3.class).getName());

        try {
            logger.info("Init transaction.");
            entityManager.getTransaction().begin();

            Client client = new Client("Marcos", "Factory");
            client.setPaymentType("CREDIT");
            entityManager.persist(client);

            Invoice invoice = new Invoice("Amazon.com", 350L);
            invoice.setClient(client);
            entityManager.persist(invoice);

            Address address1 = new Address("Address x y x", 1);
            Address address2 = new Address("Address x y x", 2);

            client.getAddresses().add(address1);
            client.getAddresses().add(address2);

            entityManager.persist(client);

            entityManager.getTransaction().commit();
            logger.info("Commit transaction.");

            System.out.println(client);

            logger.info("Init transaction.");
            entityManager.getTransaction().begin();

            Client client2 = entityManager.find(Client.class, client.getId());
            client2.getAddresses().remove(address1);

            entityManager.getTransaction().commit();
            logger.info("Commit transaction.");

            System.out.println(client2);

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

    }
}

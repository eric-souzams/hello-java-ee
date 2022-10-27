package org.jakarta.hibernate.jpa;

import jakarta.persistence.EntityManager;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jakarta.hibernate.jpa.config.JpaConfig;
import org.jakarta.hibernate.jpa.model.entity.*;

import java.util.logging.Logger;

public class JpaApplication8 {
    public static void main(String[] args) {
        EntityManager entityManager = JpaConfig.getEntityManager();
        Logger logger = Logger.getLogger(LoggerFactory.logger(JpaApplication8.class).getName());

        try {
            logger.info("Init transaction.");
            entityManager.getTransaction().begin();

            Client client = new Client("Marcos", "Factory");
            client.setPaymentType("CREDIT");

            ClientDetails clientDetails = new ClientDetails(true, 5000L);
            client.addDetail(clientDetails);
            entityManager.persist(client);

            Invoice invoice = new Invoice("Amazon.com", 350L);
            Invoice invoice2 = new Invoice("Amazon.com.br", 350L);
            client.addInvoices(invoice).addInvoices(invoice2);

            Address address1 = new Address("Address x y x", 1);
            Address address2 = new Address("Address x y x", 2);
            client.addAddress(address1).addAddress(address2);

            entityManager.getTransaction().commit();
            logger.info("Commit transaction.");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }



        entityManager = JpaConfig.getEntityManager();

        Client client2 = entityManager.find(Client.class, 1L);
        System.out.println(client2.getName() + ", addresses: " + client2.getAddresses());

        entityManager.close();
    }
}

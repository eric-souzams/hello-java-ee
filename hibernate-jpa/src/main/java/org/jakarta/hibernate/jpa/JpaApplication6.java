package org.jakarta.hibernate.jpa;

import jakarta.persistence.EntityManager;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jakarta.hibernate.jpa.config.JpaConfig;
import org.jakarta.hibernate.jpa.model.entity.Client;
import org.jakarta.hibernate.jpa.model.entity.ClientDetails;

import java.util.logging.Logger;

public class JpaApplication6 {
    public static void main(String[] args) {
        EntityManager entityManager = JpaConfig.getEntityManager();
        Logger logger = Logger.getLogger(LoggerFactory.logger(JpaApplication6.class).getName());

        try {
            logger.info("Init transaction.");
            entityManager.getTransaction().begin();

            Client client = new Client("Marcos", "Factory");
            client.setPaymentType("CREDIT");

            ClientDetails clientDetails = new ClientDetails(true, 5000L);
            client.addDetail(clientDetails);

            entityManager.persist(client);

            entityManager.getTransaction().commit();
            logger.info("Commit transaction.");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }
}

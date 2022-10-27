package org.jakarta.hibernate.jpa;

import jakarta.persistence.EntityManager;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jakarta.hibernate.jpa.config.JpaConfig;
import org.jakarta.hibernate.jpa.model.entity.Client;
import org.jakarta.hibernate.jpa.model.entity.Invoice;

import java.util.logging.Logger;

public class JpaApplication4 {
    public static void main(String[] args) {
        EntityManager entityManager = JpaConfig.getEntityManager();
        Logger logger = Logger.getLogger(LoggerFactory.logger(JpaApplication4.class).getName());

        try {
            logger.info("Init transaction.");
            entityManager.getTransaction().begin();

            Client client = new Client("Marcos", "Factory");
            client.setPaymentType("CREDIT");

            Invoice invoice = new Invoice("Amazon.com", 350L);
            Invoice invoice2 = new Invoice("Amazon.com.br", 350L);

            client.addInvoices(invoice)
                  .addInvoices(invoice2);

            entityManager.persist(client);

            entityManager.getTransaction().commit();
            logger.info("Commit transaction.");

            System.out.println(client);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

    }
}

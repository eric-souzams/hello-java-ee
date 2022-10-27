package org.jakarta.hibernate.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jakarta.hibernate.jpa.config.JpaConfig;
import org.jakarta.hibernate.jpa.model.entity.Client;
import org.jakarta.hibernate.jpa.model.entity.Invoice;

import java.util.logging.Logger;

public class JpaApplication5 {
    public static void main(String[] args) {
        EntityManager entityManager = JpaConfig.getEntityManager();
        Logger logger = Logger.getLogger(LoggerFactory.logger(JpaApplication5.class).getName());

        try {
            logger.info("Init transaction.");
            entityManager.getTransaction().begin();

            Client client = new Client("Marcos", "Factory");
            client.setPaymentType("CREDIT");

            entityManager.persist(client);

            entityManager.getTransaction().commit();
            logger.info("Commit transaction.");


            logger.info("Init transaction.");
            entityManager.getTransaction().begin();

//            Client client1 = entityManager.find(Client.class, 1L);

            TypedQuery<Client> query = entityManager.createQuery("select c from Client c where id=:id", Client.class);
            query.setParameter("id", 1L);

            Client client1 = query.getSingleResult();

            client1.setPaymentType("CREDIT");

            Invoice invoice = new Invoice("Amazon.com", 350L);
            Invoice invoice2 = new Invoice("Amazon.com.br", 350L);

            client1.addInvoices(invoice)
                  .addInvoices(invoice2);

            entityManager.getTransaction().commit();
            logger.info("Commit transaction.");

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

    }
}

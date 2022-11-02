package eric.local.org.ear.ejb.producers;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

@ApplicationScoped
public class ProducerResources {

    @PersistenceUnit(name = "mysqlConUser")
    private EntityManagerFactory entityManagerFactory;

    @Produces
    @RequestScoped
    private EntityManager entityManagerBean() {
        return entityManagerFactory.createEntityManager();
    }

    public void close(@Disposes EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
            System.out.println("Closing EM.");
        }
    }

}

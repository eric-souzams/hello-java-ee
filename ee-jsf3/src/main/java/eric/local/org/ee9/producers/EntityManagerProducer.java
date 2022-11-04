package eric.local.org.ee9.producers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class EntityManagerProducer {

    @PersistenceContext(name = "connectionJPA")
    private EntityManager entityManager;

    @Produces
    @RequestScoped
    public EntityManager entityManager() {
        return entityManager;
    }

}

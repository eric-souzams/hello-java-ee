package eric.local.org.repository;

import eric.local.org.model.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SchemaGeneration {

    public static void main(String[] args) {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("connectionJpaHibernate");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            List<Empresa> empresas = entityManager.createQuery("from Empresa", Empresa.class).getResultList();

            empresas.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

package org.jakarta.hibernate.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.jakarta.hibernate.jpa.config.JpaConfig;
import org.jakarta.hibernate.jpa.model.entity.Client;

import java.util.List;

public class JpaApplication2 {
    public static void main(String[] args) {
        EntityManager entityManager = JpaConfig.getEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> query = criteriaBuilder.createQuery(Client.class);
        Root<Client> from = query.from(Client.class);

        query.select(from);
        List<Client> resultList = entityManager.createQuery(query).getResultList();
        resultList.forEach(System.out::println);

        entityManager.close();
    }
}

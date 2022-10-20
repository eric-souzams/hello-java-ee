package org.jakarta.hibernate.jpa;

import jakarta.persistence.EntityManager;
import org.jakarta.hibernate.jpa.config.JpaConfig;
import org.jakarta.hibernate.jpa.model.entity.Client;

import java.util.Arrays;
import java.util.List;

public class JpaApplication {

    public static void main(String[] args) {
        EntityManager entityManager = JpaConfig.getEntityManager();

//        List<Client> clients = entityManager.createQuery("select c from Client c", Client.class).getResultList();
//        clients.forEach(System.out::println);

//        Query query = entityManager.createQuery("select c from Client c where c.paymentType=?1", Client.class);
//        query.setParameter(1, "DEBIT");
//        query.setMaxResults(1);
//        Client client = (Client) query.getSingleResult();
//        System.out.println(client);

//        Client client = entityManager.find(Client.class, 1L);
//        System.out.println(client);

//        try {
            entityManager.getTransaction().begin();

            Client client = new Client(null, "Maria", "Soares", "Paypal");
            entityManager.persist(client);

            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback();
//            e.printStackTrace();
//        } finally {
//            entityManager.close();
//        }
//
//        EntityManager entityManager2 = JpaConfig.getEntityManager();
        List<Client> clients = entityManager.createQuery("select c from Client c", Client.class).getResultList();
        clients.forEach(System.out::println);

//        try {
            Client client2 = entityManager.find(Client.class, 6L);

            entityManager.getTransaction().begin();
            client2.setName("Mano Brasol");
            entityManager.persist(client2);

            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback();
//            e.printStackTrace();
//        }

//        try {
//            Client client = entityManager.find(Client.class, 1L);
//
//            entityManager.getTransaction().begin();
//
//            entityManager.remove(client);
//
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            entityManager.getTransaction().rollback();
//            e.printStackTrace();
//        }

//        ClientService clientService = new ClientServiceImpl(entityManager);
//        List<Client> clients = clientService.findAll();
//        clients.forEach(System.out::println);

//---------------------------------------------------------------------------------------------------------------------

//        Client client = entityManager.createQuery("select c from Client c where c.id=:idClient", Client.class)
//                .setParameter("idClient", 3L)
//                .getSingleResult();
//        System.out.println(client);

//        String client = entityManager.createQuery("select c.name from Client c where c.id=:idClient", String.class)
//                .setParameter("idClient", 3L)
//                .getSingleResult();
//        System.out.println(client);

//        Object[] client = entityManager.createQuery("select c.name, c.id from Client c where c.id=:idClient", Object[].class)
//                .setParameter("idClient", 3L)
//                .getSingleResult();
//        System.out.println(Arrays.toString(client));

//        List<Object[]> client = entityManager.createQuery("select c.name, c.id from Client c", Object[].class)
//                .getResultList();
//        client.forEach(System.out::println);

//        List<Client> resultList = entityManager.createQuery("select new Client(c.name, c.underName) from Client c", Client.class).getResultList();
//        resultList.forEach(System.out::println);
//
//        List<ClientDto> resultList2 = entityManager.createQuery("select new org.jakarta.hibernate.jpa.model.dto.ClientDto(c.name, c.underName) from Client c", ClientDto.class).getResultList();
//        resultList2.forEach(System.out::println);

//        List<String> resultList = entityManager.createQuery("select distinct(c.name) from Client c", String.class).getResultList();
//        resultList.forEach(System.out::println);

//        Long total = entityManager.createQuery("select count(distinct(c.name)) from Client c", Long.class).getSingleResult();
//        System.out.println(total);

//        List<String> resultList = entityManager.createQuery("select concat(c.name, ' ', c.underName) as completeName from Client c", String.class).getResultList();
//        List<String> resultList = entityManager.createQuery("select c.name || ' ' || c.underName as completeName from Client c", String.class).getResultList();
//        List<String> resultList = entityManager.createQuery("select upper(concat(c.name, ' ', c.underName)) as completeName from Client c", String.class).getResultList();
//        List<String> resultList = entityManager.createQuery("select lower(concat(c.name, ' ', c.underName)) as completeName from Client c", String.class).getResultList();
//        resultList.forEach(System.out::println);

//        List<Client> resultList = entityManager.createQuery("select c from Client c where c.name like :name1", Client.class)
//                .setParameter("name1", "%ma%")
//                .getResultList();
//        resultList.forEach(System.out::println);

//        List<Client> resultList = entityManager.createQuery("select c from Client c where c.id between 2 and 5", Client.class)
//                .getResultList();
//        List<Client> resultList = entityManager.createQuery("select c from Client c order by c.name asc", Client.class)
//                .getResultList();
//        resultList.forEach(System.out::println);

//        Long total = entityManager.createQuery("select count(c) as total from Client c", Long.class).getSingleResult();
//        Long total = entityManager.createQuery("select max(c.id) as total from Client c", Long.class).getSingleResult();
//        Long total = entityManager.createQuery("select min(c.id) as total from Client c", Long.class).getSingleResult();
//        Long total = entityManager.createQuery("select length(c.id) as total from Client c", Long.class).getSingleResult();
//        Long total = entityManager.createQuery("select min(length(c.name)) as total from Client c", Long.class).getSingleResult();
//        Long total = entityManager.createQuery("select max(length(c.name)) as total from Client c", Long.class).getSingleResult();
//        Long total = entityManager.createQuery("select sum(c.id) as total from Client c", Long.class).getSingleResult();
//        Long total = entityManager.createQuery("select avg(c.id) as total from Client c", Long.class).getSingleResult();
//        System.out.println(total);

//        List<Object[]> resultList = entityManager.createQuery("select c.name, length(c.name) from Client c where " +
//                "length(c.name) = (select min(length(c.name)) from Client c)", Object[].class).getResultList();
//        resultList.forEach(t -> {
//            Arrays.asList(t).forEach(System.out::print);
//            System.out.println("");
//        });

        entityManager.close();
    }

}

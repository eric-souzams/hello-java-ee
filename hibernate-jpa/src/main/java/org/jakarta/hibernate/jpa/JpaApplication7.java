package org.jakarta.hibernate.jpa;

import jakarta.persistence.EntityManager;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jakarta.hibernate.jpa.config.JpaConfig;
import org.jakarta.hibernate.jpa.model.entity.Course;
import org.jakarta.hibernate.jpa.model.entity.Student;

import java.util.logging.Logger;

public class JpaApplication7 {
    public static void main(String[] args) {
        EntityManager entityManager = JpaConfig.getEntityManager();
        Logger logger = Logger.getLogger(LoggerFactory.logger(JpaApplication7.class).getName());

        try {
            logger.info("Init transaction.");
            entityManager.getTransaction().begin();

            Student student1 = new Student("Joao", "Lucas");
            Student student2 = new Student("Mario", "Palster");

            Course course1 = new Course("Java", "Maria");
            Course course2 = new Course("PHP", "Luan");

            student1.addCourse(course1);
            student1.addCourse(course2);

            student2.addCourse(course1);

            entityManager.persist(student1);
            entityManager.persist(student2);

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

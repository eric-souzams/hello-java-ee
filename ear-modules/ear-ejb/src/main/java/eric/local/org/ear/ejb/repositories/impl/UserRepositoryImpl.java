package eric.local.org.ear.ejb.repositories.impl;

import eric.local.org.ear.ejb.models.entities.User;
import eric.local.org.ear.ejb.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class UserRepositoryImpl implements UserRepository {

    @Inject
    private EntityManager entityManager;

    @Override
    public List<User> listAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

}

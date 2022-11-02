package eric.local.org.ear.ejb.services.impl;

import eric.local.org.ear.ejb.models.entities.User;
import eric.local.org.ear.ejb.repositories.UserRepository;
import eric.local.org.ear.ejb.services.UserService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository repository;

    @Override
    public List<User> listAll() {
        return repository.listAll();
    }

}

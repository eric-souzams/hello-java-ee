package eric.local.org.ear.ejb.repositories;

import eric.local.org.ear.ejb.models.entities.User;

import java.util.List;

public interface UserRepository {

    List<User> listAll();

}

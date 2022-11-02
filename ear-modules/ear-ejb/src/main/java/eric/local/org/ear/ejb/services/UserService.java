package eric.local.org.ear.ejb.services;

import eric.local.org.ear.ejb.models.entities.User;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface UserService {

    List<User> listAll();

}

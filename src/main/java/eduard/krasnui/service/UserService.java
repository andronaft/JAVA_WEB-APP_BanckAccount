package eduard.krasnui.service;

import eduard.krasnui.model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {

    User register(User user);

    User login(User user);

    List<User> findAll();

    User findByUsername(String username);

    User findByEmail(String email);

    ArrayList<User> findByFirstName(String firstName);

    ArrayList<User> findByLastName(String lastName);

    ArrayList<User> findByFirstNameAndLastName(String firstName, String lastName);

    User findById(Long id);

    Boolean checkUsername(String username);

    Boolean checkEmail(String email);

    User activateUser(Long id);

    Boolean isAdmin(User user);
}

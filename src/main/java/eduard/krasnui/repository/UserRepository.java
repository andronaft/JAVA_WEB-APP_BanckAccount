package eduard.krasnui.repository;

import eduard.krasnui.model.Role;
import eduard.krasnui.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
    User findByEmail(String email);
    List<User> findByFirstNameAndLastName(String firstName, String lastName);
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);

    User findByUsernameContains(String name);
    User findByEmailContains(String email);
    List<User> findByFirstNameContains(String firstName);
    List<User> findByLastNameContains(String lastName);

    List<User> findByRolesEquals(Role role);


    User getByIdAndRolesEquals(Long id, Role role);
    User findByUsernameAndRolesEquals(String username, Role role);
    User findByEmailAndRolesEquals(String email, Role role);
    List<User> findByFirstNameAndLastNameAndRolesEquals(String firstName,String lastName ,Role role);
    List<User> findByFirstNameAndRolesEquals(String firstName , Role role);
    List<User> findByLastNameAndRolesEquals(String lastName, Role role);
}
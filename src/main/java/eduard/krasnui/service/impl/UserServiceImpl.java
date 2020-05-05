package eduard.krasnui.service.impl;

import eduard.krasnui.model.Role;
import eduard.krasnui.model.Status;
import eduard.krasnui.model.User;
import eduard.krasnui.repository.RoleRepository;
import eduard.krasnui.repository.UserRepository;
import eduard.krasnui.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;


    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(8);

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.NOT_ACTIVE);

        User registeredUser = userRepository.save(user);

        return registeredUser;
    }

    @Override
    public User login(User user) {
        User findUser = userRepository.findByUsername(user.getUsername());
        if(findUser.getPassword().equals(passwordEncoder.encode(user.getPassword()))){
            return findUser;
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> result = userRepository.findAll();

        return result;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public ArrayList<User> findByFirstName(String firstName) {
        return (ArrayList<User>) userRepository.findByFirstName(firstName);
    }

    @Override
    public ArrayList<User> findByLastName(String lastName) {
        return (ArrayList<User>) userRepository.findByLastName(lastName);
    }

    @Override
    public ArrayList<User> findByFirstNameAndLastName(String firstName, String lastName) {
        return (ArrayList<User>) userRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }

         return result;
    }

    @Override
    public Boolean checkUsername(String username) {
        return userRepository.findByUsername(username) != null;
    }

    @Override
    public Boolean checkEmail(String email) {
        return userRepository.findByEmail(email) != null;
    }

    @Override
    public User activateUser(Long id) {
        User user = userRepository.getOne(id);
        user.setStatus(Status.ACTIVE);
        return userRepository.save(user);
    }

    @Override
    public Boolean isAdmin(User user) {
        User finduser = login(user);
        boolean isAdmin = false;
        for(Role string:finduser.getRoles()){
            if(string.equals("ADMIN")) {
            isAdmin = true;
            }
        }
        return isAdmin;
    }

}

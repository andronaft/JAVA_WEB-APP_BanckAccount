package eduard.krasnui.service;

import eduard.krasnui.model.Role;

import java.util.ArrayList;

public interface RoleService {
    ArrayList<Role> findAll();
    Role findById(Long id);
}

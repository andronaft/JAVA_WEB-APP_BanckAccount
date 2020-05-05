package eduard.krasnui.service.impl;

import eduard.krasnui.model.Role;
import eduard.krasnui.repository.RoleRepository;
import eduard.krasnui.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public ArrayList<Role> findAll() {
        return (ArrayList<Role>) roleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.getOne(id);
    }
}

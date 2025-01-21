package com.app.foodapp.services;

import com.app.foodapp.models.Roles;
import com.app.foodapp.repositories.RolesRepository;
import com.app.foodapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public List<Roles> getAllRoles() {
        return this.rolesRepository.findAll();
    }

    public Optional<Roles> getRoleById(Long id) {
        return this.rolesRepository.findById(id);
    }

    public Roles getRoleByName(String name) {
        return this.rolesRepository.findRoleByName(name);
    }

    public void deleteRoleById(Long id) {
        Roles rolesOptional = this.rolesRepository.findById(id).orElseThrow(() ->
            new RuntimeException("Rol no encontrado con ID: " + id));
    }

    public Roles createRole(Roles role) {
        Roles newRole = new Roles();

        newRole.setName(role.getName());
        newRole.setDescription(role.getDescription());

         return this.rolesRepository.save(newRole);
    }


}

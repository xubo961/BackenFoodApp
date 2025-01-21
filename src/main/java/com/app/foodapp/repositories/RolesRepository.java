package com.app.foodapp.repositories;

import com.app.foodapp.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 *
 * JPA nos facilita algunas funciones CRUD por defecto
 * CREATE, READ, UPDATE, DELETE
 *
 * */

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

    Roles findRoleByName(String name);

}

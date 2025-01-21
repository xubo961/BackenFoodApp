package com.app.foodapp.repositories;

import com.app.foodapp.models.Users;
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
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

}

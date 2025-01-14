package com.app.foodapp.controllers;

import com.app.foodapp.models.Users;
import com.app.foodapp.repositories.UserRepository;
import com.app.foodapp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * localhost:8080/api
 *
 * context-path de application.properties la url queda: localhost:8080/api
 *
 *En este controlador la URL es: localhost:8080/api/users
 */

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/create")
    public ResponseEntity<Users> createUser() {
        Users user = new Users();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john@doe.com");
        user.setPassword("password");
        user.setImage("hola.png");
        user.setPhone("123456789");

        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = this.usersService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}

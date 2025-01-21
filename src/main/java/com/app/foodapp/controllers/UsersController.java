package com.app.foodapp.controllers;

import com.app.foodapp.models.Users;
import com.app.foodapp.repositories.UserRepository;
import com.app.foodapp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * localhost:8080/api
 *
 * context-path de application.properties la url queda: localhost:8080/api
 *
 *En este controlador la URL es: localhost:8080/api/users
 */

/*
 * localhost:8080
 *
 * context-path de application.properties la url queda: localhost:8080/api
 *
 * En este controlador la URL es: localhost:8080/api/users
 * */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    // localhost:8080/api/users -> si no hay parámetro en GetMapping
    // localhost:8080/api/users/get-users
    @GetMapping("/get-users")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = this.usersService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    //localhost:8080/api/users/create
    @PostMapping("/create")
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        Users createUser = this.usersService.createUser(user);
        return ResponseEntity.ok(createUser);
    }

}
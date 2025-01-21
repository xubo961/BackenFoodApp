package com.app.foodapp.controllers;

import com.app.foodapp.models.Roles;
import com.app.foodapp.models.Users;
import com.app.foodapp.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @GetMapping ("/get-roles")
    public ResponseEntity<List<Roles>> getAllRoles() {
        List<Roles> users = this.rolesService.getAllRoles();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/create")
    public ResponseEntity<Roles> createRole(@RequestBody Roles role) {
        Roles user = this.rolesService.createRole(role);
        return ResponseEntity.ok(user);
    }

}

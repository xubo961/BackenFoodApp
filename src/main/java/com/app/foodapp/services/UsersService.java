package com.app.foodapp.services;

import com.app.foodapp.models.Users;
import com.app.foodapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        return this.userRepository.findAll();
    }

    public Optional<Users> getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public Optional<Users> getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public void deleteUserById(long id) {
        Users userOptional = this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
        this.userRepository.deleteById(id);
    }

    public Users updateUser(Users user, Long id) {
        Users userOptional = this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        userOptional.setFirstName(user.getFirstName());
        userOptional.setLastName(user.getLastName());
        userOptional.setEmail(user.getEmail());
        userOptional.setPhone(user.getPhone());
        userOptional.setImage(user.getImage());

        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            userOptional.setPassword(user.getPassword());
        }

        return this.userRepository.save(userOptional);

    }

    public Users createUser(Users user) {
        return this.userRepository.save(user);
    }

}

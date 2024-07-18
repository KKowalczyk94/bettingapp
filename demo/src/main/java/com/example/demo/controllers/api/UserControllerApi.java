package com.example.demo.controllers.api;

import com.example.demo.Entities.user.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserControllerApi {
    List<User> getAllUsers();
    ResponseEntity<User> getUserById(UUID id);
    User createUser(User user);
    ResponseEntity<User> updateUser(UUID id, User user);
    ResponseEntity<Void> deleteUser(UUID id);
    ResponseEntity<User> createRandomUser();
}

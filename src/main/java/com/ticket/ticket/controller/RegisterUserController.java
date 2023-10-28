package com.ticket.ticket.controller;

import com.ticket.ticket.entity.RegisterUser;
import com.ticket.ticket.entity.User;
import com.ticket.ticket.service.Implemntation.RegisterUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RegisterUserController {
    @Autowired
    private RegisterUserServiceImpl registerUserServiceImpl;

    // Handle HTTP POST requests to create a new user
    @PostMapping("/create/user")
    public String createUser(@RequestBody RegisterUser registerUser) {
        try {
            registerUserServiceImpl.createUser(registerUser);
            return "User registered successfully";
        } catch (Exception e) {
            return "Failed to register user: " + e.getMessage();
        }
    }

    // Handle HTTP GET requests to retrieve a user by their ID
    @GetMapping("/user/{userId}")
    public RegisterUser getUser(@PathVariable int userId) {
        try {
            return registerUserServiceImpl.getUserById(userId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

}

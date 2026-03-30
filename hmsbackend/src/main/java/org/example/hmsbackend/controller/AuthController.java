package org.example.hmsbackend.controller;

import org.example.hmsbackend.entity.User;
import org.example.hmsbackend.repository.UserRepository;
import org.example.hmsbackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> request) {
        return authService.authenticate(request.get("username"), request.get("password"));
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}


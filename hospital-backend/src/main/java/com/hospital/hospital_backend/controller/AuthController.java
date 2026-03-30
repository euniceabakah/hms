package com.hospital.hospital_backend.controller;

import com.hospital.hospital_backend.model.User;
import com.hospital.hospital_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    // Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        String role     = body.get("role");

        Optional<User> found = userRepo.findByUsername(username);
        if (found.isEmpty() || !found.get().getPassword().equals(password)
                || !found.get().getRole().equals(role)) {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid credentials"));
        }
        User u = found.get();
        return ResponseEntity.ok(Map.of(
                "userId",   u.getId(),
                "username", u.getUsername(),
                "role",     u.getRole()
        ));
    }

    // Update profile
    @PatchMapping("/profile/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable String id,
                                           @RequestBody Map<String, String> body) {
        return userRepo.findById(id).map(u -> {
            if (body.containsKey("firstName"))  u.setFirstName(body.get("firstName"));
            if (body.containsKey("lastName"))   u.setLastName(body.get("lastName"));
            if (body.containsKey("email"))      u.setEmail(body.get("email"));
            if (body.containsKey("phone"))      u.setPhone(body.get("phone"));
            if (body.containsKey("specialty"))  u.setSpecialty(body.get("specialty"));
            if (body.containsKey("password"))   u.setPassword(body.get("password"));
            return ResponseEntity.ok(userRepo.save(u));
        }).orElse(ResponseEntity.notFound().build());
    }
}
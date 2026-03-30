package com.hospital.hospital_backend.controller;

import com.hospital.hospital_backend.model.User;
import com.hospital.hospital_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository repo;

    @GetMapping
    public List<User> getAll() { return repo.findAll(); }

    @PostMapping
    public User create(@RequestBody User user) { return repo.save(user); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
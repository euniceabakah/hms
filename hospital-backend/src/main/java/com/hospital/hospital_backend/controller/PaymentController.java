package com.hospital.hospital_backend.controller;

import com.hospital.hospital_backend.model.Payment;
import com.hospital.hospital_backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository repo;

    @GetMapping
    public List<Payment> getAll() { return repo.findAll(); }

    @PostMapping
    public Payment create(@RequestBody Payment payment) { return repo.save(payment); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
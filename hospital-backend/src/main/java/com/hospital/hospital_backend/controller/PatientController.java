package com.hospital.hospital_backend.controller;

import com.hospital.hospital_backend.model.Patient;
import com.hospital.hospital_backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientRepository repo;

    @GetMapping
    public List<Patient> getAll() { return repo.findAll(); }

    @GetMapping("/doctor/{doctorId}")
    public List<Patient> getByDoctor(@PathVariable String doctorId) {
        return repo.findByDoctorId(doctorId);
    }

    @PostMapping
    public Patient create(@RequestBody Patient patient) { return repo.save(patient); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
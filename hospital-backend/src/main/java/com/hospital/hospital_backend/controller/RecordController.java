package com.hospital.hospital_backend.controller;

import com.hospital.hospital_backend.model.MedicalRecord;
import com.hospital.hospital_backend.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/records")
public class RecordController {

    @Autowired
    private MedicalRecordRepository repo;

    @GetMapping
    public List<MedicalRecord> getAll() { return repo.findAll(); }

    @GetMapping("/doctor/{doctorId}")
    public List<MedicalRecord> getByDoctor(@PathVariable String doctorId) {
        return repo.findByDoctorId(doctorId);
    }

    @PostMapping
    public MedicalRecord create(@RequestBody MedicalRecord record) { return repo.save(record); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
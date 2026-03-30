package com.hospital.hospital_backend.controller;

import com.hospital.hospital_backend.model.Appointment;
import com.hospital.hospital_backend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository repo;

    @GetMapping
    public List<Appointment> getAll() { return repo.findAll(); }

    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getByDoctor(@PathVariable String doctorId) {
        return repo.findByDoctorId(doctorId);
    }

    @PostMapping
    public Appointment create(@RequestBody Appointment appt) { return repo.save(appt); }

    @PatchMapping("/status/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable String id,
                                          @RequestParam String status) {
        return repo.findById(id).map(a -> {
            a.setStatus(status);
            return ResponseEntity.ok(repo.save(a));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
package org.example.hmsbackend.controller;

import org.example.hmsbackend.entity.Appointment;
import org.example.hmsbackend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/create")
    public Appointment create(@RequestBody Appointment app) {
        return appointmentService.create(app);
    }

    @GetMapping("/all")
    public List<Appointment> all() {
        return appointmentService.getAll();
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> doctorAppointments(@PathVariable String doctorId) {
        return appointmentService.getByDoctor(doctorId);
    }

    @PatchMapping("/status/{id}")
    public Appointment updateStatus(@PathVariable String id, @RequestParam String status) {
        return appointmentService.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable String id) {
        appointmentService.delete(id); // <-- call service, NOT repository directly
    }
}
package org.example.hmsbackend.service;

import org.example.hmsbackend.entity.Appointment;
import org.example.hmsbackend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment create(Appointment appointment) {
        appointment.setStatus("PENDING");
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> getByDoctor(String doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public Appointment updateStatus(String id, String status) {
        Appointment app = appointmentRepository.findById(id).orElseThrow();
        app.setStatus(status);
        return appointmentRepository.save(app);
    }

    public void delete(String id) {
        appointmentRepository.deleteById(id);
    }
}
package com.hospital.hospital_backend.repository;

import com.hospital.hospital_backend.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PatientRepository extends MongoRepository<Patient, String> {
    List<Patient> findByDoctorId(String doctorId);
}
package com.hospital.hospital_backend.repository;

import com.hospital.hospital_backend.model.MedicalRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MedicalRecordRepository extends MongoRepository<MedicalRecord, String> {
    List<MedicalRecord> findByDoctorId(String doctorId);
}
package com.hospital.hospital_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "records")
public class MedicalRecord {
    @Id
    private String id;
    private String patientName;
    private String diagnosis;
    private String prescription;
    private String date;
    private String notes;
    private String status; // Stable, Critical
    private String doctorId;
}
package com.hospital.hospital_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "appointments")
public class Appointment {
    @Id
    private String id;
    private String patientName;
    private String date;
    private String time;
    private String reason;
    private String status; // Pending, Done, Cancelled
    private String doctorId;
}
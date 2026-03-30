package com.hospital.hospital_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "payments")
public class Payment {
    @Id
    private String id;
    private String patientName;
    private double amount;
    private String date;
    private String method;
    private String status;
}
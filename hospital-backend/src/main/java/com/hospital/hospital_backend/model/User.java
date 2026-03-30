package com.hospital.hospital_backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String role; // admin, doctor, receptionist
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String specialty;
    private String licenseNo;
}
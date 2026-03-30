package com.hospital.hospital_backend.repository;

import com.hospital.hospital_backend.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {}
package com.microecom.payment_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microecom.payment_service.Model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
    
}

package com.microecom.customer_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microecom.customer_service.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    
}

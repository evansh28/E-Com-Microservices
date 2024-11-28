package com.microecom.customer_service.Model;


public record CustomerResponse(Integer id, 
    String firstName, 
    String lastName, 
    String email, 
    Address address
    ) {
} 

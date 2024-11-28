package com.microecom.customer_service.Services;

import com.microecom.customer_service.Model.Address;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRecord(

    Integer id, 
    @NotNull(message = "First Name is Required")
    String firstName, 

    @NotNull(message = "Last Name is Required")
    String lastName, 

    @NotNull(message = "Email is Required")
    @Email(message = "Enter Valid Email")
    String email, 
    
    Address address) {

    
}

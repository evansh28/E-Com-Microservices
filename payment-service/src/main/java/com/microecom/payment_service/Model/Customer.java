package com.microecom.payment_service.Model;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Validated
public record Customer(
    Integer id,

    @NotNull(message = "First Name Required")
    String firstName,

    @NotNull(message = "Last Name Required")
    String lastName,

    @NotNull(message = "Email Required")
    @Email(message = "Email should be valid")
    String email
) {

} 
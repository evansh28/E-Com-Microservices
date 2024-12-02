package com.microecom.notification_service.Models;

import java.math.BigDecimal;

public record PaymentConfirmation(
    String orderRefrence,

    BigDecimal amount,

    PaymentMethod paymentMethod,

    String customerFirstName,

    String customerLastName,

    String customerEmail
) {
} 
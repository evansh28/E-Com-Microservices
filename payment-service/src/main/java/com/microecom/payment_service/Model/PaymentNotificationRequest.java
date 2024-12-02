package com.microecom.payment_service.Model;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
    String refrence,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    String customerFirstName,
    String customerLastName,
    String customerEmail

) {
    
}

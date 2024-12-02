package com.microecom.payment_service.Model;

import java.math.BigDecimal;

public record PaymentRequest(
    Integer id,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderRefrence,
    Customer customer
) {
    
}

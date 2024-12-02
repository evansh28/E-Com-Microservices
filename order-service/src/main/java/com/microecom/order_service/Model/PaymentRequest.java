package com.microecom.order_service.Model;

import java.math.BigDecimal;

public record PaymentRequest(
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderRefrence,
    CustomerRecord customer
) {
} 
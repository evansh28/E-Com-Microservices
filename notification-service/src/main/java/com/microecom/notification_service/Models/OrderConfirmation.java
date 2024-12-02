package com.microecom.notification_service.Models;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
    String orderRefrence,
    BigDecimal totalAmount,
    PaymentMethod paymentMethod,
    Customer customer,
    List<Product> products
) {
} 
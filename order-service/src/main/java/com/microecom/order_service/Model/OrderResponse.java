package com.microecom.order_service.Model;

import java.math.BigDecimal;

public record OrderResponse(
    Integer orderId,
    String refrence,
    BigDecimal totalAmount,
    PaymentMethod paymentMethod,
    Integer customerId
) {
    
}

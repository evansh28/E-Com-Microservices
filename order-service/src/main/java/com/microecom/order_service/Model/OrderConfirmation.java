package com.microecom.order_service.Model;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
    String orderRefrence,
    BigDecimal totalAmount,
    PaymentMethod paymentMethod,
    CustomerRecord customer,
    List<PurchaseResponse> products
) {
    
}

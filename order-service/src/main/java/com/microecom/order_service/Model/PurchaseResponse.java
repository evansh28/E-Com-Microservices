package com.microecom.order_service.Model;

import java.math.BigDecimal;

public record PurchaseResponse(
    Integer productId,
    String name,
    String descp,
    BigDecimal price,
    double quantity
) {

} 
package com.microecom.notification_service.Models;

import java.math.BigDecimal;

public record Product(
    Integer productId,
    String name,
    String desc,
    BigDecimal price,
    double quantity
) {
} 

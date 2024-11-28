package com.microecom.product_service.Model;

import java.math.BigDecimal;

public record ProductPurchaseResponce(
    Integer productId,
    String name,
    String discp,
    BigDecimal price,
    double quantity
) {
    
}

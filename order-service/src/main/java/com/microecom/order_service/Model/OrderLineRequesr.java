package com.microecom.order_service.Model;

public record OrderLineRequesr(
    Integer id,
    Integer orderId,
    Integer productId,
    double quantity
) {
    
}

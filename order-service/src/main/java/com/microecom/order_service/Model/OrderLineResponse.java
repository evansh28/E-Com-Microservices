package com.microecom.order_service.Model;

public record OrderLineResponse(
    Integer orderId,
    double quantity
) {
    
}

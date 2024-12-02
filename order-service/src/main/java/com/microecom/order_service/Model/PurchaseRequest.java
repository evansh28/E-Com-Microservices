package com.microecom.order_service.Model;

import jakarta.validation.constraints.NotNull;

public record PurchaseRequest(

    @NotNull(message = "Product is Mendateory")
    Integer id,

    @NotNull(message = "Quantity is Mandateory")
    double quantity
) {

} 
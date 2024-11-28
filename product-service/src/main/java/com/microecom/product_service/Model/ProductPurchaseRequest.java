package com.microecom.product_service.Model;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(

@NotNull(message = "Id Cant be null")
    Integer productId,

    @NotNull(message = "This is required parameter")
    double quantity
) {
    
}

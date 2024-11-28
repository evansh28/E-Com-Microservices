package com.microecom.product_service.Model;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public record ProductRequest(

    Integer id,

    @NotNull(message = "Product Name is Requires")
    String name,

    @NotNull(message = "Product Descricption is Requires")
    String descricption,

    @Positive(message = "Quantity should be positive")
    double availableQuantity,

    @Positive(message = "Product Price Should be positive")
    BigDecimal price,

    @NotNull(message = "Category Id is Requires")
    Integer categoryId
) {
    
}

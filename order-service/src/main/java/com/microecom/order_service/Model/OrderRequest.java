package com.microecom.order_service.Model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderRequest(
    Integer id,
    String refrence,

    @Positive(message = "Ammount should be Positive")
    BigDecimal amount,

    @NotNull(message = "Payment method should be precised")
    PaymentMethod paymentMethod,

    @NotNull(message = "Customer should be present")
    @NotEmpty(message = "Customer should be present")
    @NotBlank(message = "Customer should be present")
    Integer customerId,

    @NotEmpty(message = "You have to purchanse at least one Product")
    List<PurchaseRequest> products
) {

} 
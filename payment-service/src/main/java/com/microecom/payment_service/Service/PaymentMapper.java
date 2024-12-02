package com.microecom.payment_service.Service;

import com.microecom.payment_service.Model.Payment;
import com.microecom.payment_service.Model.PaymentRequest;

public class PaymentMapper {

    public Payment toPayment(PaymentRequest paymentRequest) {
        return Payment.builder()
        .id(paymentRequest.id())
        .amount(paymentRequest.amount())
        .PaymentMethod(paymentRequest.paymentMethod())
        .orderId(paymentRequest.orderId())
        .build();
    }

}
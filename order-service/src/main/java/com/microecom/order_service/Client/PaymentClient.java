package com.microecom.order_service.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microecom.order_service.Model.PaymentRequest;

@FeignClient(name = "payment-service", url = "${application.config.payment-url}")
public interface PaymentClient {

    @PostMapping
    Integer orderPaymentrequest(@RequestBody PaymentRequest paymentRequest);
    
} 

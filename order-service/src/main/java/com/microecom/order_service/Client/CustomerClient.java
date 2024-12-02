package com.microecom.order_service.Client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microecom.order_service.Model.CustomerRecord;

@FeignClient(name = "customer-service", url = "${application.config.customer-url}")
public interface CustomerClient {

    @GetMapping("/{id}")
    Optional<CustomerRecord> fingCustomerById(@PathVariable Integer id);
    
}

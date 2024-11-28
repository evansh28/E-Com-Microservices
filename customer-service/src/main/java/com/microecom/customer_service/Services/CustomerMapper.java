package com.microecom.customer_service.Services;

import org.springframework.stereotype.Service;

import com.microecom.customer_service.Model.Customer;
import com.microecom.customer_service.Model.CustomerResponse;

@Service
public class CustomerMapper {

    public Customer toCustomer(CustomerRecord record) {

        if(record == null){
            return null;
        }

        return Customer.builder()
        .id(record.id())
        .firstName(record.firstName())
        .lastName(record.lastName())
        .email(record.email())
        .address(record.address())
        .build();
    }


    public CustomerResponse findCustomer(Customer record){

        return new CustomerResponse(record.getId(), record.getFirstName(), record.getLastName(), record.getEmail(), record.getAddress());

    }
    
}

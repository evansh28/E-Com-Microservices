package com.microecom.customer_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microecom.customer_service.Model.CustomerResponse;
import com.microecom.customer_service.Services.CustomerRecord;
import com.microecom.customer_service.Services.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("add")
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRecord record){

        String result = customerService.createCustomer(record);
        return ResponseEntity.ok(result);

    }

    @PutMapping("update")
    public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CustomerRecord record){

        customerService.updateCustomer(record);

        return ResponseEntity.accepted().build();

    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerResponse>> getAllCustomer(){

        List<CustomerResponse> customers = customerService.getAll();
        
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/exist/{id}")
    public ResponseEntity<Boolean> existById(@PathVariable Integer id){

        return ResponseEntity.ok(customerService.isExist(id));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){

        return ResponseEntity.ok(customerService.getBy(id));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);

        return ResponseEntity.accepted().build();

    }
    
}

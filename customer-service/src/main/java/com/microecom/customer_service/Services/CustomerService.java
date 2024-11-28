package com.microecom.customer_service.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microecom.customer_service.Model.Customer;
import com.microecom.customer_service.Model.CustomerResponse;
import com.microecom.customer_service.Repository.CustomerRepository;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public String createCustomer(CustomerRecord record) {

        var customer = customerRepository.save(customerMapper.toCustomer(record));

        return customer.getFirstName();
    }

    public void updateCustomer(CustomerRecord record) {

        var customer = customerRepository.findById(record.id())
                .orElseThrow(() -> new RuntimeException("Customer not Exist"));

        mergeCustomer(customer, record);
        customerRepository.save(customer);

    }

    private void mergeCustomer(Customer customer, CustomerRecord record) {

        if (StringUtils.isNotBlank(record.firstName())) {
            customer.setFirstName(record.firstName());
        }
        if (StringUtils.isNotBlank(record.lastName())) {
            customer.setLastName(record.lastName());
        }
        if (StringUtils.isNotBlank(record.email())) {
            customer.setEmail(record.email());
        }
        if (record.address() != null) {
            customer.setAddress(record.address());
            ;
        }

    }

    public List<CustomerResponse> getAll() {

        return customerRepository.findAll().stream().map(customerMapper::findCustomer).collect(Collectors.toList());

    }

    public boolean isExist(Integer id) {

        return customerRepository.findById(id).isPresent();

    }

    public CustomerResponse getBy(Integer id) {

        return customerRepository.findById(id).map(customerMapper::findCustomer)
                .orElseThrow(() -> new RuntimeException("Customer Not Exist"));

    }

    public void deleteCustomer(Integer id) {

        customerRepository.deleteById(id);
        
    }

}

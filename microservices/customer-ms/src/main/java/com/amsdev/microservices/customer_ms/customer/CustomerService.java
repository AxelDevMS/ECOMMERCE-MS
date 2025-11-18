package com.amsdev.microservices.customer_ms.customer;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper mapper;


    public String executeSaveCustomer(CustomerDto customerDto) {
        var customer = mapper.toCustomer(customerDto);
        var savedCustomer = customerRepository.save(customer);
        return savedCustomer.getId();
    }

    public CustomerDto executeGetCustomer(String customerId) {
        return customerRepository.findById(customerId)
                .map(mapper::toCustomerResponse)
                .orElseThrow();
    }

    public List<CustomerDto> executeGetListCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(mapper::toCustomerResponse)
                .toList();
    }

    public void executeDeleteCustomer(String customerId) {
        customerRepository.findById(customerId).orElseThrow();
        customerRepository.deleteById(customerId);
    }
}

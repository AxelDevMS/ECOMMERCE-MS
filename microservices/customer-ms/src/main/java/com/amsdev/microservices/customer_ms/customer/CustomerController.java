package com.amsdev.microservices.customer_ms.customer;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> executeCreateCustomer(@Valid @RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.executeSaveCustomer(customerDto));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> executeGetCustomer(@PathVariable("customerId") String customerId){
        return ResponseEntity.ok(customerService.executeGetCustomer(customerId));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> executeGetListCustomer(){
        return ResponseEntity.ok(customerService.executeGetListCustomer());
    }

    @PutMapping
    public ResponseEntity<String> executeUpdateCustomer(@Valid @RequestBody CustomerDto customerDto){
        customerService.executeSaveCustomer(customerDto);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<CustomerDto> executeDeleteCustomer(@PathVariable("customerId") String customerId){
        customerService.executeDeleteCustomer(customerId);
        return ResponseEntity.accepted().build();
    }


}

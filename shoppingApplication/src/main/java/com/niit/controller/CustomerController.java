package com.niit.controller;

import com.niit.domain.Customer;
import com.niit.exception.CustomerAlreadyExists;
import com.niit.exception.CustomerIdNotFound;
import com.niit.exception.ProductNotFound;
import com.niit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class CustomerController {
    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/saveItem")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) throws CustomerAlreadyExists {
        return new ResponseEntity<>(service.saveCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/getValue")
    public ResponseEntity<?> getCustomer() {
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteValue/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) throws CustomerIdNotFound {
        return new ResponseEntity<>(service.deleteCustomer(customerId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getValue/{productName}")
    public ResponseEntity<?> getByName(@PathVariable String productName) throws ProductNotFound {
        return new ResponseEntity<>(service.findAllCustomerFromProductName(productName), HttpStatus.ACCEPTED);
    }
}

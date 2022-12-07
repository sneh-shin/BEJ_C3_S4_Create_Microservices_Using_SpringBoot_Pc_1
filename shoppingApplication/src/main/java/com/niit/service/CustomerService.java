package com.niit.service;

import com.niit.domain.Customer;
import com.niit.exception.CustomerAlreadyExists;
import com.niit.exception.CustomerIdNotFound;
import com.niit.exception.ProductNotFound;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer) throws CustomerAlreadyExists;
    boolean deleteCustomer(int customerId) throws CustomerIdNotFound;
    List<Customer> getAllCustomers();
    List<Customer> findAllCustomerFromProductName(String productName) throws ProductNotFound;
}

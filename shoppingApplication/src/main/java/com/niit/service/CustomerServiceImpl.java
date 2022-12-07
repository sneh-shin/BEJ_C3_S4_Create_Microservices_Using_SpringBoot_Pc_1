/*
 *Author Name: Sneha Shinde
 *Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.service;

import com.niit.domain.Customer;
import com.niit.exception.CustomerAlreadyExists;
import com.niit.exception.CustomerIdNotFound;
import com.niit.exception.ProductNotFound;
import com.niit.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository repository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer saveCustomer(Customer customer) throws CustomerAlreadyExists {
        if (repository.findById(customer.getCustomerId()).isPresent()) {
            throw new CustomerAlreadyExists();
        }
            return repository.save(customer);
        }

    @Override
    public boolean deleteCustomer(int customerId) throws CustomerIdNotFound {
        boolean result = false;
        if(repository.findById(customerId).isEmpty()) {
            throw new CustomerIdNotFound();
        }else {
            repository.deleteById(customerId);
            result = true;
        }
        return result;
    }
    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public List<Customer> findAllCustomerFromProductName(String productName) throws ProductNotFound {
       if(repository.findAllCustomerFromProductName(productName).isEmpty()){
           throw new ProductNotFound();
       }
       return repository.findAllCustomerFromProductName(productName);
    }
}

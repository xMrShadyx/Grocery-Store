package com.hhyusein.gstore.service;

import com.hhyusein.gstore.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAll();
    Customer findById(Long id);
    Customer findByEmail(String email);

    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer, Long id);
    void deleteCustomerById(Long id);
}

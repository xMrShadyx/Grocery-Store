package com.hhyusein.gstore.service.impl;

import com.hhyusein.gstore.Repository.CustomerRepository;
import com.hhyusein.gstore.exception.DuplicateRecordException;
import com.hhyusein.gstore.exception.EmptyRecordException;
import com.hhyusein.gstore.exception.ResourceNotFoundException;
import com.hhyusein.gstore.model.Customer;
import com.hhyusein.gstore.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        List<Customer> getAllCustomers = customerRepository.findAll();

        if (getAllCustomers.isEmpty()) {
            throw new EmptyRecordException("There is no record's in Database.");
        }

        return getAllCustomers;
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Search property, Address with ID: %d not found in the Database", id)));
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Search property, Email %s not found in the Database", email)));
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Customer lookForEmail = this.findByEmail(customer.getCustomerEmail());

        if (lookForEmail != null) {
            throw new DuplicateRecordException(String.format("This Customer already exists at our DB with ID %d", customer.getCustomerId()));
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) {
        Customer foundCustomer = findById(id);
        Customer customerToUpdate = Customer.builder()
                .customerId(foundCustomer.getCustomerId())
                .customerName(customer.getCustomerName())
                .customerPhone(customer.getCustomerPhone())
                .customerEmail(customer.getCustomerEmail())
                .dateBecameCustomer(LocalDateTime.now())
                .otherCustomerDetails(customer.getOtherCustomerDetails())
                .build();
        return saveCustomer(customerToUpdate);
    }

    @Override
    public void deleteCustomerById(Long id) {
        Customer checkIfIdIsInDatabase = customerRepository.findById(id)
                .orElseThrow(() -> new EmptyRecordException(String.format("Can't complete delete operation ID %d does not exist.", id)));
        customerRepository.deleteCustomerById(checkIfIdIsInDatabase.getCustomerId());

    }
}

package com.hhyusein.gstore.Repository;

import com.hhyusein.gstore.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findById(Long id);
    Optional<Customer> findByEmail(String email);

    Customer updateCustomer(Customer customer, Long id);
    void deleteCustomerById(Long id);
}

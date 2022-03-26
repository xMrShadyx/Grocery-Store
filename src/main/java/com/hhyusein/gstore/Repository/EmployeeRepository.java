package com.hhyusein.gstore.Repository;

import com.hhyusein.gstore.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findById(Long id);
    Optional<Employee> findByPhone(String phone);

    Employee updateEmployee(Employee employee, Long id);
    void deleteEmployeeById(Long id);
}

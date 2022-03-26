package com.hhyusein.gstore.service;

import com.hhyusein.gstore.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(Long id);
    Employee findByPhone(String phone);

    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Employee employee, Long id);
    void deleteEmployeeById(Long id);
}

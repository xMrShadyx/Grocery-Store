package com.hhyusein.gstore.service.impl;

import com.hhyusein.gstore.Repository.EmployeeRepository;
import com.hhyusein.gstore.exception.DuplicateRecordException;
import com.hhyusein.gstore.exception.EmptyRecordException;
import com.hhyusein.gstore.exception.ResourceNotFoundException;
import com.hhyusein.gstore.model.Employee;
import com.hhyusein.gstore.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        List<Employee> getAllEmployees = employeeRepository.findAll();

        if (getAllEmployees.isEmpty()) {
            throw new EmptyRecordException("There is no record's in Database.");
        }

        return getAllEmployees;
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Search property, Employee with ID: %d not found in the Database", id)));
    }

    @Override
    public Employee findByPhone(String phone) {
        return employeeRepository.findByPhone(phone)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Search property, Employee phone: %s not found in the Database", phone)));
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Employee lookForPhone = this.findByPhone(employee.getEmployeePhone());

        if (lookForPhone != null) {
            throw new DuplicateRecordException(String.format("This Employee already exists at our DB with ID %d", employee.getEmployeeId()));
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Employee foundEmployee = findById(id);
        Employee employeeToUpdate = Employee.builder()
                .employeeId(foundEmployee.getEmployeeId())
                .employeeAddressId(employee.getEmployeeAddressId())
                .employeeName(employee.getEmployeeName())
                .employeePhone(employee.getEmployeePhone())
                .otherEmployeeDetails(employee.getOtherEmployeeDetails())
                .build();
        return saveEmployee(employeeToUpdate);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee checkIfIdIsInDatabase = employeeRepository.findById(id)
                .orElseThrow(() -> new EmptyRecordException(String.format("Can't complete delete operation ID %d does not exist.", id)));
        employeeRepository.deleteEmployeeById(checkIfIdIsInDatabase.getEmployeeId());
    }
}

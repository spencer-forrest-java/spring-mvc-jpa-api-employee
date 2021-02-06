package com.spencer.forrest.employeerestapi.service;

import com.spencer.forrest.employeerestapi.dto.EmployeeDTO;
import com.spencer.forrest.employeerestapi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(EmployeeDTO employeeDTO);
    void deleteById(int id);
}

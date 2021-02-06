package com.spencer.forrest.employeerestapi.controller;

import com.spencer.forrest.employeerestapi.dto.EmployeeDTO;
import com.spencer.forrest.employeerestapi.entity.Employee;
import com.spencer.forrest.employeerestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeDTO.setId(0);
        return employeeService.save(employeeDTO);
    }

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.save(employeeDTO);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String updateEmployee(@PathVariable int employeeId) {
        employeeService.deleteById(employeeId);
        return "Deleted employee with id: " + employeeId;
    }
}

package com.spencer.forrest.employeerestapi.service;

import com.spencer.forrest.employeerestapi.dao.EmployeeDAO;
import com.spencer.forrest.employeerestapi.dto.EmployeeDTO;
import com.spencer.forrest.employeerestapi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(@Qualifier("employeeDAOJPAImpl") EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee save(EmployeeDTO employeeDTO) {
        return employeeDAO.save(employeeDTO);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}

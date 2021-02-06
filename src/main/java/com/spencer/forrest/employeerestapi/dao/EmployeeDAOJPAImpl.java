package com.spencer.forrest.employeerestapi.dao;

import com.spencer.forrest.employeerestapi.dto.EmployeeDTO;
import com.spencer.forrest.employeerestapi.entity.Employee;
import com.spencer.forrest.employeerestapi.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        Query query = entityManager.createQuery("from Employee", Employee.class);

        // get results and create DTO list
        @SuppressWarnings("unchecked")
        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {
        // check if employee is in database
        Employee employee = entityManager.find(Employee.class, id);
        if(employee == null) {
            throw new NotFoundException("Employee not found with id: " + id);
        }

        return employee;
    }

    @Override
    public Employee save(EmployeeDTO employeeDTO) {
        // create new employee
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());

        // save employee
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        // check if employee is in database
        Employee employee = entityManager.find(Employee.class, id);
        if(employee == null) {
            throw new NotFoundException("Employee not found with id: " + id);
        }

        // create deletion query
        Query query = entityManager.createQuery("delete from Employee  where id=:id");
        query.setParameter("id", id);

        // execute query
        query.executeUpdate();
    }
}

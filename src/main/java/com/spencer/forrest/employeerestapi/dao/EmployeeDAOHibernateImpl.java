package com.spencer.forrest.employeerestapi.dao;

import com.spencer.forrest.employeerestapi.dto.EmployeeDTO;
import com.spencer.forrest.employeerestapi.entity.Employee;
import com.spencer.forrest.employeerestapi.exception.NotFoundException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // define field for entity manager
    private final EntityManager entityManager;

    // setup constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> query = currentSession.createQuery("from Employee ", Employee.class);

        // get results
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        // get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // check if employee is in database
        Employee employee = currentSession.get(Employee.class, id);
        if(employee == null) {
            throw new NotFoundException("Employee not found with id: " + id);
        }

        return employee;
    }

    @Override
    public Employee save(EmployeeDTO employeeDTO) {
        // get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create new employee
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());

        // save employee
        currentSession.saveOrUpdate(employee);

        // return saved employee
        return employee;
    }

    @Override
    public void deleteById(int id) {
        // get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // check if employee in database
        Employee employee = currentSession.get(Employee.class, id);
        if(employee == null) {
            throw new NotFoundException("Employee not found with id: " + id);
        }

        // delete employee
        currentSession.delete(employee);
    }
}

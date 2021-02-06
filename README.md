#  Employee REST API

The user can perform CRUD operations through this REST API.

#### Technologies used

1. Maven
2. Spring Boot
3. Spring Web MVC
4. JSON
5. Hibernate
6. JPA Specifications
7. MySQL
8. JDBC

### Description

The user can perform CRUD operations on an 
<a href="src/main/java/com/spencer/forrest/employeerestapi/entity/Employee.java">
employee </a> entity using HTTP methods:
1. POST "/api/employees" to create a new employee 
2. GET "/api/employees" to retrieve a list of all employees
3. GET "/api/employees/{employeeId}" to retrieve a specific employee using his id
4. PUT "/api/employees/" to update an employee
5. DELETE "/api/employees/{employeeId}" to delete an employee using his id

### JSON format

JSON representation of the
<a href="src/main/java/com/spencer/forrest/employeerestapi/entity/Employee.java">
employee </a> entity.
```
{
    "id": 99,
    "firstName": "John",
    "lastName": "Clayton",
    "email": "jhon@email.com"
}
```

### Software Architecture

There are 3 layers:
1. <a href="src/main/java/com/spencer/forrest/employeerestapi/controller">Controller</a>
2. <a href="src/main/java/com/spencer/forrest/employeerestapi/service">Service</a>
3. <a href="src/main/java/com/spencer/forrest/employeerestapi/dao">Data Access Object (DAO)</a>

In this example there are 2 implementations of the 
<a href="src/main/java/com/spencer/forrest/employeerestapi/dao/EmployeeDAO.java">
Employee DAO
</a>:
1. One using Hibernate Session -
<a href="src/main/java/com/spencer/forrest/employeerestapi/dao/EmployeeDAOHibernateImpl.java">EmployeeDAOHibernateImpl.java</a>
2. One using Entity Manager (JPA) - 
<a href="src/main/java/com/spencer/forrest/employeerestapi/dao/EmployeeDAOJPAImpl.java">EmployeeDAOJPAImpl.java</a>

To change which implementation to use, modify the file 
<a href="src/main/java/com/spencer/forrest/employeerestapi/service/EmployeeServiceImpl.java">
EmployeeServiceImpl.java
</a> on line 19:
1. For Hibernate -> @Qualifier("employeeDAOHibernateImpl")
2. For JPA -> @Qualifier("employeeDAOJPAImpl")

### Configuration

The <a href="src/main/resources/application.properties">application.properties</a> file contains the information needed 
for the application to connect to a database (url, username, password).

### Database
The file <a href="sql/employee.sql">employee.sql<a/> is a script to create an employee table and insert sample data.



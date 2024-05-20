package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.model.EmployeeMongo;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    // MySQL methods
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Long empid);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Long empid);

    // MongoDB methods
    EmployeeMongo saveEmployeeMongo(EmployeeMongo employee);
    List<EmployeeMongo> getAllEmployeesMongo();
    Optional<EmployeeMongo> getEmployeeByIdMongo(String id);
    EmployeeMongo updateEmployeeMongo(EmployeeMongo employee);
    void deleteEmployeeMongo(String id);
}

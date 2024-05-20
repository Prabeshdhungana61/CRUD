package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.model.EmployeeMongo;
import com.example.employee.repository.EmployeeMongoRepository;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMongoRepository employeeMongoRepository;

    // MySQL methods implementation

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long empid) {
        return employeeRepository.findById(empid);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long empid) {
        employeeRepository.deleteById(empid);
    }

    // MongoDB methods implementation

    @Override
    public EmployeeMongo saveEmployeeMongo(EmployeeMongo employee) {
        return employeeMongoRepository.save(employee);
    }

    @Override
    public List<EmployeeMongo> getAllEmployeesMongo() {
        return employeeMongoRepository.findAll();
    }

    @Override
    public Optional<EmployeeMongo> getEmployeeByIdMongo(String id) {
        return employeeMongoRepository.findById(id);
    }

    @Override
    public EmployeeMongo updateEmployeeMongo(EmployeeMongo employee) {
        return employeeMongoRepository.save(employee);
    }

    @Override
    public void deleteEmployeeMongo(String id) {
        employeeMongoRepository.deleteById(id);
    }
}

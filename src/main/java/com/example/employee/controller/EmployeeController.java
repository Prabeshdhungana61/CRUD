package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.model.EmployeeMongo;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // MySQL endpoints
    @PostMapping("/employees")
    public ResponseEntity<Employee> createNewEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/{empid}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long empid) {
        Optional<Employee> employee = employeeService.getEmployeeById(empid);
        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/employees/{empid}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long empid, @RequestBody Employee employee) {
        employee.setEmpid(empid);
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{empid}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long empid) {
        employeeService.deleteEmployee(empid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // MongoDB endpoints
    @PostMapping("/mongo/employees")
    public ResponseEntity<EmployeeMongo> createNewEmployeeMongo(@RequestBody EmployeeMongo employee) {
        EmployeeMongo createdEmployee = employeeService.saveEmployeeMongo(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/mongo/employees")
    public ResponseEntity<List<EmployeeMongo>> getAllEmployeesMongo() {
        List<EmployeeMongo> employees = employeeService.getAllEmployeesMongo();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/mongo/employees/{id}")
    public ResponseEntity<EmployeeMongo> getEmployeeByIdMongo(@PathVariable String id) {
        Optional<EmployeeMongo> employee = employeeService.getEmployeeByIdMongo(id);
        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/mongo/employees/{id}")
    public ResponseEntity<EmployeeMongo> updateEmployeeMongo(@PathVariable String id, @RequestBody EmployeeMongo employee) {
        employee.setId(id);
        EmployeeMongo updatedEmployee = employeeService.updateEmployeeMongo(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/mongo/employees/{id}")
    public ResponseEntity<Void> deleteEmployeeMongo(@PathVariable String id) {
        employeeService.deleteEmployeeMongo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

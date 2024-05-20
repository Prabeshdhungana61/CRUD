package com.example.employee.repository;

import com.example.employee.model.EmployeeMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeMongoRepository extends MongoRepository<EmployeeMongo, String> {
}

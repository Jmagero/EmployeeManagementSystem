package miu.edu.cs.employeemanagementsystem.dao;

import miu.edu.cs.employeemanagementsystem.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
}

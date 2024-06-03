package miu.edu.cs.employeemanagementsystem.service;

import miu.edu.cs.employeemanagementsystem.model.Employee;

import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> addEmployee(Employee employee);
    Optional<Employee> updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    Optional<Employee> getEmployee(int  id);
}

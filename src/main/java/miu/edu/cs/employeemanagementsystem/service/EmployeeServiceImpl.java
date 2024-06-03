package miu.edu.cs.employeemanagementsystem.service;

import lombok.RequiredArgsConstructor;
import miu.edu.cs.employeemanagementsystem.dao.EmployeeRepository;
import miu.edu.cs.employeemanagementsystem.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    @Override
    public Optional<Employee> addEmployee(Employee employee) {

        return Optional.of(employeeRepository.save(employee));
    }

    @Override
    public Optional<Employee> updateEmployee(Employee employee) {
        Optional<Employee> employee1 = employeeRepository.findById(employee.getId());
        if(employee1.isPresent()){
            Employee updatedEmployee = new Employee();
            updatedEmployee.setId(employee.getId());
            updatedEmployee.setSalary(employee.getSalary());
            updatedEmployee.setFirstName(employee.getFirstName());
            updatedEmployee.setLastName(employee.getLastName());
            return Optional.of(employeeRepository.save(updatedEmployee));
        }
        return Optional.empty();
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Optional<Employee> getEmployee(int id) {
        return Optional.of(employeeRepository.findById(id).get());
    }
}

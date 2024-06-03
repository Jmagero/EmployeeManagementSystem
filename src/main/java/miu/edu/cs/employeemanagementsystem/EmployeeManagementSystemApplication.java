package miu.edu.cs.employeemanagementsystem;

import lombok.RequiredArgsConstructor;
import miu.edu.cs.employeemanagementsystem.dao.EmployeeRepository;
import miu.edu.cs.employeemanagementsystem.model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class EmployeeManagementSystemApplication implements CommandLineRunner {
    private  final EmployeeRepository employeeRepository;

    public static void main(String[] args) {


        SpringApplication.run(EmployeeManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Employee emp1 = new Employee(1,"John", "Doe", 50000);
        Employee emp2 = new Employee(2,"Jane", "Dona", 50000);
        Employee emp3 = new Employee(3,"Alice", "Smith", 60000);
        Employee emp4 = new Employee(4,"Bob", "Brown", 45000);

        employeeRepository.saveAll(Arrays.asList(emp1, emp2, emp3, emp4));

        List<Employee> employees = employeeRepository.findAll();

        employees.stream()
                .sorted(
                        Comparator.comparing(Employee::getSalary)
                                .thenComparing(Employee::getLastName, Comparator.reverseOrder())
                ).forEach(System.out::println);

    }
}

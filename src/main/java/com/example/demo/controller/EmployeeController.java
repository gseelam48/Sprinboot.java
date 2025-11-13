package com.example.demo.controller;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return "Employee Saved Successfully";
    }

    @GetMapping("/getEmployee")
    public List<Employee> getEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(emp -> {
            Employee employee = new Employee();
            employee.setId(emp.getId());
            employee.setName(emp.getName().toUpperCase());
            return employee;
        }).toList();
    }
    @GetMapping("/getModifiedEmployees")
    public List<Employee> getModifiedEmployees() {
        return employeeRepository.findAll().stream()
                .map(emp -> {
                    Employee employee = new Employee();
                    employee.setId(emp.getId());
                    employee.setName(emp.getName().toUpperCase());
                    employee.setSalary(emp.getSalary() + 5000);
                    return employee;
                })
                .toList();
    }

    @GetMapping("/salaryAbove/{amount}")
    public List<Employee> getEmployeesBySalary(@PathVariable double amount) {
        return employeeRepository.findAll().stream()
                .filter(emp -> emp.getSalary() > amount)
                .toList();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable long id) {
        return employeeRepository.findById( id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable long id) {
        employeeRepository.deleteById( id);
        return "Employee deleted successfully with ID: " + id;
    }

    @PutMapping("/updateSalary/{id}/{salary}")
    public String updateSalary(@PathVariable long id, @PathVariable double salary) {
        Optional<Employee> empOpt = employeeRepository.findById( id);
        if (empOpt.isPresent()) {
            Employee emp = empOpt.get();
            emp.setSalary(salary);
            employeeRepository.save(emp);
            return "Salary updated successfully for " + emp.getName();
        } else {
            return "Employee not found!";
        }
    }

    @GetMapping("/totalSalary")
    public double getTotalSalary() {
        return employeeRepository.findAll().stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @GetMapping("/sortBySalary")
    public List<Employee> sortBySalary() {
        return employeeRepository.findAll().stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList();
    }

    @GetMapping("/top3Salaries")
    public List<Employee> getTop3Salaries() {
        return employeeRepository.findAll().stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .toList();
    }

    @GetMapping("/averageSalary")
    public double getAverageSalary() {
        return employeeRepository.findAll().stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    @GetMapping("/byName/{name}")
    public List<Employee> getByName(@PathVariable String name) {
        return employeeRepository.findAll().stream()
                .filter(emp -> emp.getName().equalsIgnoreCase(name))
                .toList();
    }

    @GetMapping("/anyAbove100k")
    public boolean anyAbove100k() {
        return employeeRepository.findAll().stream()
                .anyMatch(emp -> emp.getSalary() > 100000);
    }

    @GetMapping("/evenSalaryIds")
    public List<Integer> getEvenSalaryIds() {
        return employeeRepository.findAll().stream()
                .filter(emp -> emp.getSalary() % 2 == 0)
                .map(Employee::getId)
                .collect(Collectors.toList());
    }

    @GetMapping("/groupByRange")
    public Map<String, List<Employee>> groupByRange() {
        return employeeRepository.findAll().stream()
                .collect(Collectors.groupingBy(emp -> {
                    if (emp.getSalary() < 50000) return "Below 50k";
                    else if (emp.getSalary() <= 70000) return "50k–70k";
                    else return "Above 70k";
                }));
    }
}


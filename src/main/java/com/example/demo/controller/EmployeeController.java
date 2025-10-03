package com.example.demo.controller;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Iterable<Employee> getEmployee() {
        return employeeRepository.findAll();
    }
}

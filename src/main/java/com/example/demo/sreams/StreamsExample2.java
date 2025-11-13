package com.example.demo.sreams;

import com.example.demo.entity.CGEmployee;

import java.util.*;
import java.util.stream.Collectors;


public class StreamsExample2 {
    public static void main(String[] args) {
        List<CGEmployee> empList = new ArrayList<>();
        empList.add(new CGEmployee(1, "Shank", 28, 123, "F", "HR", "Bore", 2020));
        empList.add(new CGEmployee(2, "Francesca",  29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new CGEmployee(3, "Ramesh", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new CGEmployee(4, "Melanie", 32, 125, "F", "HR", "Chennai", 2013));
        empList.add(new CGEmployee(5, "Padma", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new CGEmployee(6, "Milad", 27, 140, "M", "IT", "Guru gram", 2017));
        empList.add(new CGEmployee(7, "Uma", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new CGEmployee(8, "Ali", 23, 145, "M", "IT", "Trivandrum", 2015));
        empList.add(new CGEmployee(9, "Ram", 25, 160, "M", "IT", "Bore", 2010));
        //Group the Employees by city.
        Map<String, List<CGEmployee>> employeesByCity = empList.stream().collect(Collectors.groupingBy(CGEmployee::getCity));
        System.out.println(employeesByCity);
        // Group the Employees by age.
        Map<Integer, List<CGEmployee>> employeesByAge = empList.stream().collect(Collectors.groupingBy(CGEmployee::getAge));
        System.out.println(employeesByAge);
        //3. Find the count of male and female employees present in the organization.
        Map<String, Long> countOfMaleFemale = empList.stream().collect(Collectors.groupingBy(CGEmployee::getGender, Collectors.counting()));
        System.out.println(countOfMaleFemale);
        //Print the names of all distinct departments in the organization.
        List<String> name = empList.stream().map(CGEmployee::getDeptName).distinct().toList();
        System.out.println(name);
        //Print employee details whose age is greater than 28 in the organisation.4
        List<CGEmployee> ageGreaterThan28 = empList.stream().filter(cgEmployee -> cgEmployee.getAge() > 28).toList();
        System.out.println(ageGreaterThan28);

    }
}

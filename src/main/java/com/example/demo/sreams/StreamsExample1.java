package com.example.demo.sreams;

import com.example.demo.entity.Employees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsExample1 {
    public static void main(String[] args) {
        List<Employees> employeeList = new ArrayList<>();

        Employees employee1 = new Employees(10, "gopi", 50000);
        Employees employee2 = new Employees(11, "rutesh", 30000);
        Employees employee3 = new Employees(14, "raja", 60000);
        Employees employee4 = new Employees(13, "narendra", 20000);
        Employees employee5 = new Employees(16, "ganesh", 40000);

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);                                                                         // lambda expression or method reference
        employeeList.add(employee5);
        String minName = employeeList.stream().min(Comparator.comparingDouble(Employees::getSalary))
                .map(Employees::getName).orElse(null);

        String maxName = employeeList.stream().max(Comparator.comparingDouble(Employees::getSalary))
                .map(Employees::getName).orElse(null);
        List<Employees> filterBySalary = employeeList.stream().filter(emp -> emp.getSalary() > 50000).toList();
        List<String> getName = employeeList.stream().map(emp -> emp.getName()).toList();
        Employees getHighestSalary = employeeList.stream().max(Comparator.comparing(Employees::getSalary)).orElse(null);
        Employees getLowestSalary = employeeList.stream().min(Comparator.comparing(Employees::getSalary)).orElse(null);
        List<String> covertNameUppercase = employeeList.stream().map(emp -> emp.getName().toUpperCase()).toList();
        double totalSalary = employeeList.stream().mapToDouble(Employees::getSalary).sum();
        List<Employees> sortBySalary = employeeList.stream().sorted(Comparator.comparing(Employees::getSalary)).toList();
        List<Employees> sortByName = employeeList.stream().sorted(Comparator.comparing(Employees::getName).reversed()).toList();
        List<Employees> increasedSalary = employeeList.stream().map(e -> new Employees(e.getId(), e.getName(), e.getSalary() * 1.10)).toList();
        boolean greaterThan1L = employeeList.stream().anyMatch(emp -> emp.getSalary() > 100000);
        List<Employees> midSalary = employeeList.stream().filter(e -> e.getSalary() >= 40000 && e.getSalary() <= 60000).toList();
        List<Integer> isByEveNum = employeeList.stream().filter(emp -> emp.getSalary() % 2 == 0).map(Employees::getId).toList();
        double secondHighest = employeeList.stream()
                .map(Employees::getSalary)
                .sorted(Comparator.reverseOrder()).distinct()
                .skip(2)
                .findFirst()
                .orElse(0.0);    //Create a list of employee IDs whose salary is an *even number* (use modulus).
        List<Integer> idByEvenNumber = employeeList.stream().filter(emp -> emp.getSalary() % 2 == 0).map(Employees::getId).toList();
        //  15. Convert the list of employees into a *Map of id → name*.
        Map<Integer, String> idToNames = employeeList.stream().collect(Collectors.toMap(Employees::getId, Employees::getName));
        //Group employees by *salary range* (e.g., below 50k, between 50k–70k, above 70k).
        Map<String, List<Employees>> employeesBySalary = employeeList.stream().collect(Collectors.groupingBy(e -> {
            if (e.getSalary() < 50000)
                return "below 50k";
            else if (e.getSalary() <= 70000)
                return "Between 50k-70k";
            else return "above 70k";
        }));
        //Get only the *first three employees* when sorted by salary
        List<Employees> firstThreeSortBySalary = employeeList.stream().sorted(Comparator.comparing(Employees::getSalary)).limit(3).toList();
       /* System.out.println(minName);
        System.out.println(maxName);*/
        firstThreeSortBySalary.parallelStream().forEach(System.out::println);
        firstThreeSortBySalary.stream().forEach(System.out::println);

        /*System.out.println(employeesBySalary);
        System.out.println(idToNames);*/
        System.out.println("----filter by salary----");
        filterBySalary.parallelStream().forEach(System.out::println);
        filterBySalary.stream().forEach(System.out::println);
        System.out.println("----only employee names----");
        getName.parallelStream().forEach(System.out::println);
       /* System.out.println("-----employees Highest salary----");
        System.out.println(getHighestSalary);
        System.out.println("-----employees Lowest salary----");
        System.out.println(getLowestSalary);*/
        System.out.println("----- employees names to uppercase salary ----");
        covertNameUppercase.parallelStream().forEach(System.out::println);
       /* System.out.println("---- Total Salary ----");
        System.out.println(totalSalary);*/
        System.out.println("---- assending by Salary ----");
        sortBySalary.parallelStream().forEach(System.out::println);
        System.out.println("---- Decending by name ----");
        sortByName.parallelStream().forEach(System.out::println);
        System.out.println("---- Incresed by salary ----");
        increasedSalary.parallelStream().forEach(System.out::println);
       /* System.out.println("---- greater than 1l ----");
        System.out.println(greaterThan1L);
        System.out.println("---- Second heighest ----");
        System.out.println(secondHighest);*/


    }
}


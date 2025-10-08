package com.example.demo.controller;

import com.example.demo.request.ArthmRequest;
import com.example.demo.entity.Employee;
import com.example.demo.request.Request2;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping("/sayHello")
    public String sayHelloWorld() {
        return "hello world ";
    }

    @GetMapping("/sayHello1")
    public String sayHelloWorld1(@RequestParam String name) {
        return " hello " + name;
    }

    @GetMapping("/sayHello2")
    public String performArthOpp(@RequestParam int a, @RequestParam int b, @RequestParam String operation) {
        System.out.println(operation);
        if (operation.equals("add")) {
            return "addition of two numbers is " + (a + b);
        } else if (operation.equals("multiplication")) {
            return "multiplication of two numbers is " + (a * b);
        } else {
            return "invalid operation";
        }
    }

    @GetMapping("/sayHello3")
    public String checkEvenOrOdd(@RequestParam int num) {
        if (num % 2 == 0) {
            return num + " is Even  ";
        } else if (num % 2 != 0) {
            return num + " is Odd ";
        } else {
            return "not a valid number";
        }
    }
    @GetMapping("/sayHello4")
    public String checkMax(@RequestParam int a,@RequestParam int b) {
        if (a > b) {
            return "a is max ";
        } else if (b > a) {
            return "b is max" ;
        } else {
            return "invalid operation";
        }
    }
    @PostMapping("/checkMax")
    public String checkMax1(@RequestBody Map<String,Integer> request  ) {
        int a = request.get("a");
        int b = request.get("b");
        if (a > b) {
            return "a is max ";
        } else if (b > a) {
            return "b is max" ;
        } else {
            return "invalid operation";
        }
}
    @PostMapping("/checkMax2")
    public String checkMax2(@RequestBody ArthmRequest arthmRequest) {
        int a = arthmRequest.getA();
        int b = arthmRequest.getB();
        if (a > b) {
            return "a is max ";
        } else if (b > a) {
            return "b is max" ;
        } else {
            return "invalid operation";
        }

}
    @PostMapping("/checkMax3")
    public String checkMax3(@RequestBody Request2 request2) {
        int num1 = request2.getNum1();;
        int num2 = request2.getNum2();
        if (num1 > num2) {
            return "num1 is max ";
        } else if (num2 > num1) {
            return "num2 is max" ;
        } else {
            return "invalid operation";
        }
}
    @PostMapping("/checkMax4")
    public String checkMax4(@RequestBody Employee employee) {
        return employee.getId() +" "+ employee.getName();

    }
}




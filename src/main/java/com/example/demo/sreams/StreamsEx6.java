package com.example.demo.sreams;

import java.util.Arrays;
import java.util.List;

public class StreamsEx6 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2, 8, 7, 6, 4);
        List<String> fruits = Arrays.asList("apple", "grapes", "orange", "jackfruit");

        List<Integer> squaredNumbers = numbers.stream().map(num -> num * num).toList();
        for (Integer s : squaredNumbers) {
            System.out.println(s);
        }
        List<Integer> lengthOfEachString = fruits.stream().map(String::length).toList();
        for (Integer l : lengthOfEachString) {
            System.out.println(l);
        }
    }
}

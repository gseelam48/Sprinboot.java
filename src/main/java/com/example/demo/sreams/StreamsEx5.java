package com.example.demo.sreams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamsEx5 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2, 8, 7, 6, 4);
        Long greaterThanThree = numbers.stream().filter(num -> num > 3).count();
        List<Integer> sortBy = numbers.stream().sorted().toList();
        System.out.println("----SortByNumbers-----");
        for (Integer num : sortBy) {
            System.out.println(num);
        }
        List<Integer> squaredNumbers = numbers.stream().map(num -> num * num).toList();
        System.out.println("---- Squared Numbers----");
        for (Integer num : squaredNumbers) {
            System.out.println(num);
        }

        List<String> fruits = Arrays.asList("apple", "grapes", "orange", "jackfruit");
        List<String> alphabetically = fruits.stream().sorted().toList();
        System.out.println("Sort By Alphabetically");
        for (String s : alphabetically) {
            System.out.println(s);
        }
        List<String> reversed = fruits.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("----Reversed-----");
        for (String r : reversed) {
            System.out.println(r);
        }
        List<Integer> lengthOfEachString = fruits.stream().map(String::length).toList();
        System.out.println("-----Length Of Each String-----");
        for (Integer l : lengthOfEachString) {
            System.out.println(l);
        }
        List<String> upperCase = fruits.stream().map(String::toUpperCase).toList();
        System.out.println("---- Upper case---");
        for (String uc : upperCase) {
            System.out.println(uc);
        }
        List<String> limit = fruits.stream().limit(3).toList();
        System.out.println("Limit of 3");
        for (String l : limit) {
            System.out.println(l);
        }
        System.out.println("----Greater than three----");
        System.out.println(greaterThanThree);
    }
}

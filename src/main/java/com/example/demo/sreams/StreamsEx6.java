package com.example.demo.sreams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsEx6 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2, 8, 7, 6, 4);
        List<String> fruits = Arrays.asList("Apple", "Grapes", "Orange", "Jackfruit", "Pineapple");

        List<Integer> squaredNumbers = numbers.stream().map(num -> num * num).toList();
        for (Integer s : squaredNumbers) {
            System.out.println(s);
        }
        List<Integer> squaredNumbers1 = numbers.stream().map(num -> num + num).toList();
        for (Integer s : squaredNumbers1) {
            System.out.println(s);
        }
        List<Integer> lengthOfEachString = fruits.stream().map(String::length).toList();
        for (Integer l : lengthOfEachString) {
            System.out.println(l);
        }
        List<String> toUpperCase = fruits.stream().map(name -> name.toUpperCase()).toList();
        for (String sw : toUpperCase) {
            System.out.println(sw);
        }
        List<String> toLowerCase = fruits.stream().map(name -> name.toLowerCase()).toList();
        for (String tl : toLowerCase) {
            System.out.println(tl);
        }
        toUpperCase.stream().forEach(System.out::println);
        Map<String, Integer> mapToTwoLists = fruits.stream().collect(Collectors.toMap(f -> f, n -> numbers.get(fruits.indexOf(n))));
        System.out.println("map to two lists" + mapToTwoLists);
    }
}
//  static List<Integer> squaredbyNumber (int n , List<Integer> squaredNumbers ){

//}


package com.example.demo.sreams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateEx {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 8, 7, 6, 4, 9, 18, 27);
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "pear", "plum", "jackfruit");
        Predicate<Integer> isEven = n -> n % 2 == 0;
        List<Integer> evenNumbers = numbers.stream().filter(isEvenPredicate()).toList();
        Predicate<Integer> dividedByThree = n -> n % 3 == 0;
        System.out.println(filterNumbers(5, numbers));
        System.out.println(filterByLetters("a",fruits));
        System.out.println(filterByLetters1("a",fruits));
    }

    static Predicate<Integer> isEvenPredicate() {
        return n -> n % 3 == 0;
    }

    static Long filterNumbers(int number, List<Integer> numbers) {
        Predicate<Integer> dividedByNumber = n -> n % number == 0;
        return numbers.stream().filter(dividedByNumber).count();
    }

    static List<String> filterByLetters(String letter, List<String> fruits) {
        Predicate<String> fruitStartsWith = name -> name.startsWith(letter);
        return fruits.stream().filter(fruitStartsWith).toList();
    }
    static Long filterByLetters1(String letter, List<String> fruits) {
        Predicate<String> fruitStartsWith = name -> name.startsWith(letter);
        return fruits.stream().filter(fruitStartsWith).count();
    }
}

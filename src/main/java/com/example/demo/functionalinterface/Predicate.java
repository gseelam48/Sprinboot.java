package com.example.demo.functionalinterface;

@FunctionalInterface
public interface Predicate {
    boolean test(int n);
}

class PredicateInterfaceExam {
    public static void main(String[] args) {
        Predicate isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(10));
        System.out.println(isEven.test(5));
    }
}
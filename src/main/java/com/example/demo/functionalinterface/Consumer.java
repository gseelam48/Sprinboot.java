package com.example.demo.functionalinterface;

@FunctionalInterface
public interface Consumer {
    int div(int a, int b);
}

class ConsumerInterfaceExam {
    public static void main(String[] args) {
        Consumer consumer = (a, b) -> a / b;
        System.out.println(consumer.div(8, 2));
    }
}
package com.example.demo.multipleinheritanceexample;

public class MultipleInheritanceUsingDefault {
    public static void main(String[] args) {
        Book book = new Book();
        book.read();
    }
}

class Book implements Student, Student1 {

    @Override
    public void read() {
        System.out.println("Student reading book");
        Student.super.read();
        Student1.super.read();
    }
}

interface Student {
    default void read() {
        System.out.println("Student is reading");

    }
}

interface Student1 {
    default void read() {
        System.out.println("Student1 is reading");
    }
}
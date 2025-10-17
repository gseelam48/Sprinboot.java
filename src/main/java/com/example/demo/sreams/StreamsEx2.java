package com.example.demo.sreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsEx2 {
    public static void main(String[] args) {
        List<String> fruitNames1 = Arrays.asList("banana", "apple", "guava", "orange");

        for (String name : fruitNames1) {

        }
        fruitNames1.stream().forEach(name -> System.out.println(name));
    }

}

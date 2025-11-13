package com.example.demo.sreams;

import com.example.demo.dto.VehicleDto;

import java.util.Arrays;
import java.util.List;

public class StremsEx4 {
    public static void main(String[] args) {
        VehicleDto vehicleDto = new VehicleDto(3,"car");
        List<Integer> numbers = Arrays.asList(1, 22, 45, 78, 65, 35, 26, 21);
        List<String> fruits = Arrays.asList("apple", "banana", "mango", "pear", "plum", "jackfruit");
        List<Integer> numbers1 = Arrays.asList(2, 8, 5, 12, 7, 10);
        Integer max = numbers1.stream().max(Integer::compareTo).orElse(0);
        Integer min = numbers1.stream().min(Integer::compareTo).orElse(0);
        List<String> nameStartsWith = fruits.stream().filter(name -> name.startsWith("j")).toList();
        List<String> upperFruits = fruits.stream().map(String::toUpperCase).toList();
        List<Integer> filterBy = numbers.stream().filter(num ->  num % 3 == 0).toList();
        for (Integer num : filterBy) {
            System.out.println(" filter by 3 " + num);
        }
        for (String uc : upperFruits) {
            System.out.println(" upper case" + uc);
        }
        for (String sw : nameStartsWith) {
            System.out.println(" name starts with J" + sw);
        }

        System.out.println(max);
        System.out.println(min);
    }
}

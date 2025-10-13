package com.example.demo.sreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListUsingStreams {
    public static void main(String[] args) {
        List<String> fruitNames = new ArrayList<>();
        List<String> fruitNames1 = new ArrayList<>();

        fruitNames.add("apple");
        fruitNames.add("pineapple");
        fruitNames.add("Papaya");
        fruitNames.add("orange");
        fruitNames.add("grape");

        for (String s : fruitNames) {
          if ( s.toLowerCase().startsWith("p")){
            System.out.println(s);
            String upperFruit=
            s.toUpperCase(Locale.ROOT);
//            s.toUpperCase(Locale.of("p"));
            fruitNames1.add(upperFruit);
            System.out.println("updated list " + fruitNames1);
        }
    }
}
}

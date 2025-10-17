package com.example.demo.sreams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsEx3 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 22, 45, 78, 8765, 122, 87565);
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 600),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 900),
                new Transaction("2022-01-03", 500)
        );
        transactions = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .toList();

        for (Transaction t : transactions) {
            System.out.println(t.getDate() + "  " + t.getAmount());
        }
        Map<String, Integer> sumByDate = new HashMap<>();
        Set<Integer> uniqueNumbers = new HashSet<>(numbersWithDuplicates);
        List<Integer> numberswithoutDuplicates = new ArrayList<>(uniqueNumbers);
        List<Integer> intersection = new ArrayList<>(list1);
        intersection.retainAll(list2);
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();

        int evenCount = 0;
        int oddCount = 0;

        for (Integer num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
                evenNumbers.add(num);
            } else {
                oddCount++;
                oddNumbers.add(num);
            }
        }
        System.out.println("even count " + evenCount + " odd count " + oddCount);
        System.out.println(numberswithoutDuplicates);
        System.out.println("Intersecton numbers" + intersection);
        System.out.println("even number" + evenNumbers);
        System.out.println("odd numbers" + oddNumbers);
        Map<String, Integer> sumByDay = transactions
                .stream()
                .collect(Collectors.groupingBy(Transaction::getDate,
                        Collectors.summingInt(Transaction::getAmount)));
        numberswithoutDuplicates = numbersWithDuplicates.stream().distinct().collect(Collectors.toList());
        intersection = intersection.stream().filter(list2::contains).collect(Collectors.toList());
        evenNumbers = numbers.stream().filter(num -> num % 2 == 0).toList();
        oddNumbers = numbers.stream().filter(num -> num % 2 != 0).toList();
        System.out.println("even number" + evenNumbers);
        System.out.println("odd numbers" + oddNumbers);
        System.out.println(intersection);
        System.out.println(numberswithoutDuplicates);
        System.out.println(sumByDay);

    }
}

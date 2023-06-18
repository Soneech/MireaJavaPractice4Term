package org.soneech.tasks.task26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        numbers = numbers.stream().filter(new Predicate<Integer>() {
            int count = 1;
            @Override
            public boolean test(Integer integer) {
                return count++ % 5 != 0;
            }
        }).collect(Collectors.toList());

        numbers.forEach(System.out::println);
    }
}

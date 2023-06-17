package org.soneech.question5;

import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sonya", "Misha", "Vanya", "Katya");

        // names.forEach(name -> System.out.println(name));
        names.forEach(System.out::println);

        // Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        names.sort(String::compareTo);

        System.out.print("\nAfter sorting:\n");
        names.forEach(System.out::println);
    }
}

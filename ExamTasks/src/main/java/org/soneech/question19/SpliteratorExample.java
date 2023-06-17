package org.soneech.question19;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sonya", "Misha", "Vanya", "Katya");

        Spliterator<String> spliterator1 = names.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        //spliterator1.forEachRemaining(System.out::println);
        //spliterator2.forEachRemaining(System.out::println);

        System.out.println(spliterator1.estimateSize());
        System.out.println(spliterator2.estimateSize());
    }
}

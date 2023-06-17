package org.soneech.question15;

import java.util.List;

import java.util.stream.Stream;
import static java.util.stream.Stream.*;
import static java.util.stream.Collectors.toList;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        List<Integer> evenSquared = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(toList());  // using static import

        System.out.println(evenSquared);


        Stream<Integer> stream1 = of(1, 2, 3);  // of() - using static import
        Stream<Integer> stream2 = of(4, 5, 6);
        Stream<Integer> combinedStream = concat(stream1, stream2);  // concat() - using static import
        combinedStream.forEach(System.out::println);
    }
}
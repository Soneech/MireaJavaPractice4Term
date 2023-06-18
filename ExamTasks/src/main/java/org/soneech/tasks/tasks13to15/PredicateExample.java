package org.soneech.tasks.tasks13to15;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        // task 13
        Predicate<String> notNullString = Objects::nonNull;

        System.out.println("--------------------------------");
        System.out.println(notNullString.test("some string"));
        System.out.println(notNullString.test(""));
        System.out.println(notNullString.test(null));

        // task 14
        Predicate<String> notEmptyString = (s) -> !s.isEmpty();

        System.out.println("--------------------------------");
        System.out.println(notEmptyString.test(""));
        System.out.println(notEmptyString.test("some string"));

        // task 15
        Predicate<String> notNullNotEmptyString = notNullString.and(notEmptyString);

        System.out.println("--------------------------------");
        System.out.println(notNullNotEmptyString.test(""));
        System.out.println(notNullNotEmptyString.test(null));
        System.out.println(notNullNotEmptyString.test("some string"));
    }
}

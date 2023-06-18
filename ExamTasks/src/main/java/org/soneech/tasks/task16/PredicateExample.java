package org.soneech.tasks.task16;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<String> pattern =
                (s) -> (s.charAt(0) == 'J' || s.charAt(0) == 'N') && s.charAt(s.length() -1) == 'A';
        System.out.println(pattern.test("JksdjfkdfA"));
        System.out.println(pattern.test("NskdfjA"));
        System.out.println(pattern.test("Nskdfjdf"));
        System.out.println(pattern.test("skdj"));
    }
}

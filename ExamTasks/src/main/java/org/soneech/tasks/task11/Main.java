package org.soneech.tasks.task11;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Arrays.stream(args).map(String::length).forEach(System.out::println);
    }
}

package org.soneech.tasks.task19;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Integer> randomNumber = () -> (int) (Math.random() * 10);
        System.out.println(randomNumber.get());
    }
}

package org.soneech.tasks.task17;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<HeavyBox> consumer1 = (h) -> System.out.println("Отгрузили ящик с весом n");
        Consumer<HeavyBox> consumer2 = (h) -> System.out.println("Отправляем ящик с весом n");

        Consumer<HeavyBox> consumer = consumer1.andThen(consumer2);
        consumer.accept(new HeavyBox());
    }
}

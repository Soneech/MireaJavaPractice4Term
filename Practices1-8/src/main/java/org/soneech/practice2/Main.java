package org.soneech.practice2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human(20, "Anna", "Ivanova",
                        LocalDate.of(2002, 3, 15), 50));
        humans.add(new Human(25, "Ivan", "Ivanov",
                LocalDate.of(1998, 1, 15), 80));
        humans.add(new Human(22, "Anastasia", "Borisova",
                LocalDate.of(2000, 5, 28), 45));
        humans.add(new Human(18, "Dariya", "Petrova",
                LocalDate.of(2005, 2, 2), 55));
        humans.add(new Human(30, "Maksim", "Korolev",
                LocalDate.of(1992, 8, 14), 70));
        humans.add(new Human(15, "Anton", "Maksimov",
                LocalDate.of(2007, 6, 11), 70));
        humans.add(new Human(15, "Akakiy", "Akakiev",
                LocalDate.of(2007, 6, 9), 70));

        System.out.println("Исходные данные:");
        humans.forEach(System.out::println);

        System.out.println("\nДанные после сортировки по возрасту (в порядке убывания):");
        humans.stream().sorted((h1, h2) -> Integer.compare(h2.getAge(), h1.getAge())).forEach((System.out::println));

        System.out.println("\nДанные после фильтрации по имени (начинается с 'A'):");
        humans.stream().filter(human -> human.getFirstName().charAt(0) == 'A').forEach(System.out::println);

        System.out.println("\nДанные после сортировке по дате рождения:");
        humans.stream().sorted(Comparator.comparing(Human::getBirthDate)).forEach(System.out::println);

        System.out.println("\nСредний вес:");
        System.out.println(humans.stream().collect(Collectors.averagingInt(Human::getWeight)));
    }
}

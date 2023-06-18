package org.soneech.practice6;

import org.soneech.practice6.abstract_factory.clothing_factory.DestructionClothingFactory;
import org.soneech.practice6.abstract_factory.clothing_factory.IllusionClothingFactory;
import org.soneech.practice6.abstract_factory.mage_factory.DestructionMageFactory;
import org.soneech.practice6.abstract_factory.mage_factory.IllusionMageFactory;
import org.soneech.practice6.abstract_factory.mage_factory.MageFactory;
import org.soneech.practice6.builder.User;
import org.soneech.practice6.prototype.Mage;
import org.soneech.practice6.prototype.Warrior;

public class Test {
    public static void main(String[] args) {
        checkFactoryPattern();
        System.out.println("------------------------------------------------");
        checkBuilderPattern();
        System.out.println("------------------------------------------------");
        checkPrototypePattern();
        System.out.println("------------------------------------------------");
    }

    public static void checkFactoryPattern() {
        System.out.println("-- Abstract Factory Pattern --\n");
        MageFactory mageFactory;

        mageFactory = new DestructionMageFactory();
        mageFactory.create(new DestructionClothingFactory(), "fire").description();

        mageFactory = new IllusionMageFactory();
        mageFactory.create(new IllusionClothingFactory(), "snaking").description();
    }

    public static void checkBuilderPattern() {
        System.out.println("-- Builder Pattern --\n");
        User user = new User.UserBuilder("Ivan", "Ivanov")
                .age(20)
                .email("ivan.ivanov@yandex.ru")
                .phone("89251581458")
                .build();
        System.out.println(user);

        User user1 = new User.UserBuilder("Petr", "Petrov")
                .age(25)
                .build();
        System.out.println(user1);

        User user2 = new User.UserBuilder("Anna", "Ivanova")
                .phone("89131478999")
                .build();
        System.out.println(user2);

//        User user3 = new User.UserBuilder("", "").build();  // exception!
//        System.out.println(user3);
    }

    public static void checkPrototypePattern() {
        System.out.println("-- Prototype Pattern --\n");

        Warrior warrior = new Warrior("sword", 250, 280);
        Warrior warriorClone = (Warrior) warrior.copy();
        System.out.println("Original warrior: " + warrior);
        System.out.println("Warrior clone: " + warriorClone);

        Mage mage = new Mage("stick", 200, 350);
        Mage mageClone = (Mage) mage.copy();
        System.out.println("Original mage: " + mage);
        System.out.println("Mage clone: " + mageClone);
    }
}

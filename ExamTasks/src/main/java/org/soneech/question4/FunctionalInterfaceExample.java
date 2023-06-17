package org.soneech.question4;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        MyFunctionalInterface testInterface = () -> System.out.println("do something...");
        testInterface.doSomething();
    }
}
package org.soneech.other_patterns.decorator;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("It's circle");
    }
}

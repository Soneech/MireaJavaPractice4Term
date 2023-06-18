package org.soneech.other_patterns.decorator;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("It's rectangle");
    }
}

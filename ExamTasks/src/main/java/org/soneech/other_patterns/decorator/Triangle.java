package org.soneech.other_patterns.decorator;

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("It's triangle");
    }
}

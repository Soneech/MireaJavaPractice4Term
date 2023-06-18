package org.soneech.other_patterns.bridge.shapes;

import org.soneech.other_patterns.bridge.colors.Color;

public class Triangle extends Shape {
    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing triangle");
        color.fillColor();
    }
}

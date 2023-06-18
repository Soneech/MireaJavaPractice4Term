package org.soneech.other_patterns.bridge;

import org.soneech.other_patterns.bridge.colors.Blue;
import org.soneech.other_patterns.bridge.colors.Red;
import org.soneech.other_patterns.bridge.shapes.Rectangle;
import org.soneech.other_patterns.bridge.shapes.Shape;
import org.soneech.other_patterns.bridge.shapes.Triangle;

public class Test {
    public static void main(String[] args) {
        Shape shape = new Triangle(new Red());
        shape.draw();

        shape = new Rectangle(new Blue());
        shape.draw();

        shape = new Rectangle(new Red());
        shape.draw();
    }
}

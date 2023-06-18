package org.soneech.other_patterns.bridge.shapes;

import org.soneech.other_patterns.bridge.colors.Color;

public abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}

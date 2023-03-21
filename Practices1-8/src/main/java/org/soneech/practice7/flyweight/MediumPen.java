package org.soneech.practice7.flyweight;

public class MediumPen extends Pen {
    private String color;
    private BrushSize brushSize = BrushSize.MEDIUM;

    public MediumPen(String color) {
        this.color = color;
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing " + content + " with a medium " + color + " pen");
    }
}

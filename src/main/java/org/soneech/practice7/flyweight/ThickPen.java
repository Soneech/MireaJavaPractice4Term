package org.soneech.practice7.flyweight;

public class ThickPen extends Pen {
    private String color;
    private BrushSize brushSize = BrushSize.THICK;

    public ThickPen(String color) {
        this.color = color;
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing " + content + " with a thick " + color + " pen");
    }
}

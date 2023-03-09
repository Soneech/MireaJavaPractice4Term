package org.soneech.practice7.flyweight;

public class ThinPen extends Pen {
    private String color;
    private BrushSize brushSize = BrushSize.THIN;

    public ThinPen(String color) {
        this.color = color;
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing " + content + " with a thin " + color + " pen");
    }
}

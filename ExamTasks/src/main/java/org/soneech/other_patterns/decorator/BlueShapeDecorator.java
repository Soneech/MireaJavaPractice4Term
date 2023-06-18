package org.soneech.other_patterns.decorator;

public class BlueShapeDecorator extends ShapeDecorator {
    public BlueShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        super.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Сообщение от BlueShapeDecorator. Цвет границы: голубой");
    }
}

package org.soneech.other_patterns.decorator;

public class Test {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        Shape blueRectangle = new BlueShapeDecorator(new Rectangle());
        Shape blueTriangle = new BlueShapeDecorator(new Triangle());
        Shape blueCircle = new BlueShapeDecorator(new Circle());

        rectangle.draw();
        System.out.println();

        blueRectangle.draw();
        blueTriangle.draw();
        blueCircle.draw();
    }
}

package org.soneech.practice7.flyweight;

public class Test {
    public static void main(String[] args) {
        Pen redThickPen = PenFactory.createThickPen("red");
        redThickPen.draw("circle");
        Pen redThickPen1 = PenFactory.createThickPen("red");
        redThickPen1.draw("square");

        Pen blueMediumPen = PenFactory.createMediumPen("blue");
        blueMediumPen.draw("'some blue text'");
        Pen blueMediumPen1 = PenFactory.createMediumPen("blue");
        blueMediumPen1.draw("'some blue text 1'");

        Pen greenThinPen = PenFactory.createThinPen("yellow");
        greenThinPen.draw("triangle");

        System.out.println(redThickPen.hashCode());
        System.out.println(redThickPen1.hashCode());
        System.out.println(blueMediumPen.hashCode());
        System.out.println(blueMediumPen1.hashCode());
        System.out.println(greenThinPen.hashCode());
    }
}

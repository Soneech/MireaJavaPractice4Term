package org.soneech.practice7.flyweight;

import java.util.HashMap;

public class PenFactory {
    private final static HashMap<String, Pen> pensMap = new HashMap<>();

    public static Pen createThickPen(String color) {
        return createPen(color, BrushSize.THICK);
    }

    public static Pen createMediumPen(String color) {
        return createPen(color, BrushSize.MEDIUM);
    }

    public static Pen createThinPen(String color) {
        return createPen(color, BrushSize.THIN);
    }

    public static Pen createPen(String color, BrushSize brushSize) {
        String key = color + brushSize.toString();

        Pen pen = pensMap.get(key);
        if (pen != null) {
            return pen;
        }

        switch (brushSize) {
            case THIN -> pen = new ThinPen(color);
            case MEDIUM -> pen = new MediumPen(color);
            case THICK -> pen = new ThickPen(color);
            default -> { }
        }
        pensMap.put(key, pen);
        return pen;
    }
}

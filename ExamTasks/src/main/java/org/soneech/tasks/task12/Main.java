package org.soneech.tasks.task12;

import javax.swing.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class Main {
    public static void main(String[] args) { // throws PrinterException
        Printable printable = (v1, v2, v3) -> 0;
        //System.out.println(printable.print(new DebugGraphics(), new PageFormat(), 1));
    }
}

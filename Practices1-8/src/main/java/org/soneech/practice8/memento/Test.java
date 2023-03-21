package org.soneech.practice8.memento;

public class Test {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(new Document());
        editor.write("some text, line 0\n");
        editor.write("some text, line 1\n");

        editor.save();
        editor.print();

        editor.write("some text, line 2\n");
        editor.print();
        editor.restore();
        editor.print();
    }
}

package org.soneech.practice8.memento;

public class TextEditor {
    private Document document;
    private DocumentState savedState;

    public TextEditor(Document document) {
        this.document = document;
    }

    public void save() {
        savedState = document.save();
    }

    public void restore() {
        document.restore(savedState);
    }

    public void write(String text) {
        document.addText(text);
    }

    public void print() {
        System.out.println(document);
    }
}

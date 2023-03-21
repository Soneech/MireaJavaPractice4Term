package org.soneech.practice8.memento;

public class DocumentState {
    private String text;

    public DocumentState(Document document) {
        text = document.getText();
    }

    public String getText() {
        return text;
    }
}

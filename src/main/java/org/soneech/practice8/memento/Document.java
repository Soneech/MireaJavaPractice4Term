package org.soneech.practice8.memento;

public class Document {
    private StringBuilder text;

    public Document() {
        text = new StringBuilder();
    }

    public String getText() {
        return text.toString();
    }

    protected void addText(String text) {
        this.text.append(text);
    }

    public DocumentState save() {
        return new DocumentState(this);
    }

    public void restore(DocumentState savedState) {
        text = new StringBuilder(savedState.getText());
    }

    @Override
    public String toString() {
        return text.toString();
    }
}

package DesignPatterns.Memento;

public class TextEditor {
    private String text;

    public void type(String newText) {
        this.text = newText;
    }

    public String getText() {
        return text;
    }

    public Memento save() {
        return new Memento(text);
    }

    public void restore(Memento memento) {
        this.text = memento.getSavedText();
    }

    // Memento class (nested)
    public static class Memento {
        private final String savedText;

        public Memento(String text) {
            this.savedText = text;
        }

        private String getSavedText() {
            return savedText;
        }
    }
}

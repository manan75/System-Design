package DesignPatterns.Memento;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        editor.type("Hello World");
        caretaker.save(editor); // Save 1

        editor.type("New text added...");
        caretaker.save(editor); // Save 2

        editor.type("Even more changes...");

        System.out.println("Current text: " + editor.getText()); // Latest text

        caretaker.undo(editor); // Revert to "New text added..."
        System.out.println("After undo 1: " + editor.getText());

        caretaker.undo(editor); // Revert to "Hello World"
        System.out.println("After undo 2: " + editor.getText());

        caretaker.undo(editor); // Nothing left
    }
}

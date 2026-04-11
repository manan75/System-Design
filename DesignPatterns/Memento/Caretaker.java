
package DesignPatterns.Memento;

import java.util.Stack;

public class Caretaker {
    private Stack<TextEditor.Memento> history = new Stack<>();

    public void save(TextEditor editor) {
        history.push(editor.save());
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            editor.restore(history.pop());
        } else {
            System.out.println("No more undo steps.");
        }
    }
}

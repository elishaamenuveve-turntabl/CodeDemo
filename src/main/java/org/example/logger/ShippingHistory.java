package org.example.logger;

import org.example.command.Command;

import java.util.Stack;

public class ShippingHistory {
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    private static ShippingHistory instance;

    private ShippingHistory() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public static ShippingHistory getInstance() {
        if (instance == null)
            instance = new ShippingHistory();
        return instance;
    }

    public void addToStack(Command command) {
        //prototyping
        Command clone = command.clone();
        undoStack.add(clone);
        redoStack.clear();

    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.unexecute();
            redoStack.add(command);

        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.add(command);

        }

    }
}

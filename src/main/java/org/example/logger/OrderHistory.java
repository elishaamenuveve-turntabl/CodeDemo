package org.example.logger;

import org.example.command.Command;
import org.example.command.ordercommand.OrderCommand;

import java.util.Stack;

public class OrderHistory {
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    private static OrderHistory instance;

    private OrderHistory() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public static OrderHistory getInstance() {
        if (instance == null)
            instance = new OrderHistory();
        return instance;
    }

    public void addToStack(OrderCommand command) {
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

package org.example.invoker;

import org.example.command.Command;

public class Button {
    //ui information
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

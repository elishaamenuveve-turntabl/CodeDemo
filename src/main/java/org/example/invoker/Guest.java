package org.example.invoker;

import org.example.command.Command;

public class Guest {
    //guest information
    private String name;

    public Guest(String name) {
        this.name = name;
    }

    private Command command;

    public void setOrder(Command command) {
        this.command = command;
        System.out.println(name + " places order.\n" );
    }

    public String getName() {
        return name;
    }

    public void executeOrder() {
        command.execute();
    }
    public void changeOrder(Command newCommand) {
        System.out.println(name + " changes order.\n" );
        command.unexecute();
        command = newCommand;
    }

    @Override
    public String toString() {
        return name;
    }
}

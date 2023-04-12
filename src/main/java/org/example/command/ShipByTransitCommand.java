package org.example.command;

import java.util.ArrayList;

public class ShipByTransitCommand extends Command {
    ArrayList<Command> commands;

    public ShipByTransitCommand(ArrayList<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
        System.out.println("\n\n");

    }

    @Override
    public void unexecute() {
        for (int i = commands.size()-1; i >= 0; i--) {
            commands.get(i).unexecute();
        }
        System.out.println("\n\n");
    }
}

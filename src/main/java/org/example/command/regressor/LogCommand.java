package org.example.command.regressor;

import org.example.command.Command;
import org.example.logger.ShippingHistory;

public class LogCommand extends Command {
    private Command command;

    public LogCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        ShippingHistory.getInstance().addToStack(command);
        command.execute();
    }

    @Override
    public void unexecute() {
    }
}

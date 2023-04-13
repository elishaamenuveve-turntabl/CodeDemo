package org.example.command.regressor;

import org.example.command.ordercommand.OrderCommand;
import org.example.logger.OrderHistory;

public class LogCommand extends OrderCommand {
    private OrderCommand command;

    public LogCommand(OrderCommand command) {
        this.command = command;
    }

    @Override
    public void execute() {
        OrderHistory.getInstance().addToStack(command);
        command.execute();
    }

    @Override
    public void unexecute() {
        command.unexecute();
    }
}

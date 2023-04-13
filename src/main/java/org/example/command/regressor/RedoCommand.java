package org.example.command.regressor;

import org.example.command.ordercommand.OrderCommand;
import org.example.logger.OrderHistory;

public class RedoCommand  extends OrderCommand {

    @Override
    public void execute() {
        OrderHistory.getInstance().redo();
    }

    @Override
    public void unexecute() {

    }
}
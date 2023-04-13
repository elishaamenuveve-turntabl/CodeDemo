package org.example.command.regressor;

import org.example.command.ordercommand.OrderCommand;
import org.example.logger.OrderHistory;

public class UndoCommand extends OrderCommand {

    @Override
    public void execute() {
        OrderHistory.getInstance().undo();
    }

    @Override
    public void unexecute() {

    }
}

package org.example.command.regressor;

import org.example.command.Command;
import org.example.logger.ShippingHistory;

public class UndoCommand extends Command {

    @Override
    public void execute() {
        ShippingHistory.getInstance().undo();
    }

    @Override
    public void unexecute() {

    }
}

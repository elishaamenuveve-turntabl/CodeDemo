package org.example.command.regressor;

import org.example.command.Command;
import org.example.logger.ShippingHistory;

public class RedoCommand  extends Command {

    @Override
    public void execute() {
        ShippingHistory.getInstance().redo();
    }

    @Override
    public void unexecute() {

    }
}
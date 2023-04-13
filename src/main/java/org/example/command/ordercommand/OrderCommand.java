package org.example.command.ordercommand;

import org.example.command.Command;
import org.example.invoker.Guest;

public abstract class OrderCommand implements Command, Cloneable {
    protected boolean isPartOfBatchOrder;
    protected String order;
    protected Guest guest;

    public void shouldBeServedTo(Guest guest) {
        this.guest = guest;
    }

    @Override
    public OrderCommand clone() {
        try {
            return (OrderCommand) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

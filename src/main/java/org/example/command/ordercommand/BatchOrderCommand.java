package org.example.command.ordercommand;

import java.util.ArrayList;

public class BatchOrderCommand extends OrderCommand {
    ArrayList<OrderCommand> orders;

    public BatchOrderCommand(ArrayList<OrderCommand> orders) {
        this.orders = orders;
    }

    @Override
    public void execute() {
        for (OrderCommand order : orders) {
            order.isPartOfBatchOrder = true;
            order.execute();
        }
        String preparedOrders = "";

        for (OrderCommand order : orders) {
            preparedOrders = preparedOrders.equals("") ? preparedOrders : (preparedOrders + ", ");
            preparedOrders = preparedOrders + order.order;
        }
        System.out.println("Waiter sends " + preparedOrders + " to " + guest);

        System.out.println("\n\n");

    }

    @Override
    public void unexecute() {
        for (int i = orders.size()-1; i >= 0; i--) {
            orders.get(i).unexecute();
        }
        System.out.println("\n\n");
    }
}

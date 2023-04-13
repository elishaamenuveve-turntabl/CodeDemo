package org.example.command.ordercommand;

import org.example.receiver.Chef;

public class FriesOrderCommand extends OrderCommand {

    private Chef chef;
    public FriesOrderCommand(Chef chef) {
        this.chef = chef;
        order = "Fries";
    }

    @Override
    public void execute() {
        System.out.println("Waiter sends fries order to Chef " + chef.getName());
        chef.prepareOrder(order);
        if (!isPartOfBatchOrder) {
            System.out.println("Waiter sends " + order + " to " + guest + "\n");
        }
    }

    @Override
    public void unexecute() {
        System.out.println("Waiter returns "  + order + " to Chef " + chef.getName() + " \n");
    }
}

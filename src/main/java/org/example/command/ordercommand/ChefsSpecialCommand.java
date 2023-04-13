package org.example.command.ordercommand;

import org.example.receiver.Chef;

public class ChefsSpecialCommand extends OrderCommand {
    private boolean isBatchOrder;
    private Chef chef;

    public ChefsSpecialCommand(Chef chef) {
        this.chef = chef;
        order = chef.getSpecial();
    }

    @Override
    public void execute() {
        System.out.println("Waiter sends order to Chef " + chef.getName());
        chef.prepareOrder(chef.getSpecial());
        if (!isPartOfBatchOrder) {
            System.out.println("Waiter sends " + order + " to " + guest + "\n");
        }
    }

    @Override
    public void unexecute() {
        System.out.println("Waiter returns "  + order + " to Chef " + chef.getName() + " \n");
    }
}

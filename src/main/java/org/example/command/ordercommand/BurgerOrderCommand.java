package org.example.command.ordercommand;

import org.example.receiver.Chef;

public class BurgerOrderCommand extends OrderCommand {
    private Chef chef;


    public BurgerOrderCommand(Chef chef) {
        this.chef = chef;
        order = "Burger";
    }

    public void customiseBurgerOrder(String customization) {
        order = order + " " + customization;
    }


    @Override
    public void execute() {
        System.out.println("Waiter sends burger order to Chef " + chef.getName());
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

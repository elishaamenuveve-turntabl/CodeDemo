package org.example.client;

import org.example.command.ordercommand.*;
import org.example.command.regressor.LogCommand;
import org.example.invoker.Guest;
import org.example.logger.OrderHistory;
import org.example.receiver.Chef;

import java.util.ArrayList;

public class Waiter {
    public static void main(String[] args) {
        //TODO: CHEFS ARRIVE (RECEIVERS)
        Chef burgerChef = new Chef("Chris");
        burgerChef.setSpecial("Whole Bread");

        Chef friesChef = new Chef("Luci");
        friesChef.setSpecial("Apple Pie");


        //TODO: FIRST GUESTS (INVOKERS)
        //Adam and Eve arrive
        Guest adam = new Guest("Adam");
        Guest eve = new Guest("Eve");



        //TODO: CREATE ORDERS (COMMANDS)
        //Adam orders a burger without lettuce
        BurgerOrderCommand adamsBurger = new BurgerOrderCommand(burgerChef);
        adamsBurger.customiseBurgerOrder("without lettuce");
        adamsBurger.shouldBeServedTo(adam);
        adam.setOrder(new LogCommand(adamsBurger));
        adam.executeOrder();

        //Eve orders the burger chefs special
        ChefsSpecialCommand evesOrder = new ChefsSpecialCommand(friesChef);
        evesOrder.shouldBeServedTo(eve);
        eve.setOrder(new LogCommand(evesOrder));
        eve.executeOrder();




        //TODO: MORE GUESTS (INVOKERS)
        //Cain and Abel join adam and eve;
        Guest cain = new Guest("Cain");
        Guest abel = new Guest("Abel");

        //Abel wants a similar burger to adam, but with pineapple
        BurgerOrderCommand abelsBurger = (BurgerOrderCommand) adamsBurger.clone();
        abelsBurger.customiseBurgerOrder("with pineapple");
        abelsBurger.shouldBeServedTo(abel);
        abel.setOrder(new LogCommand(abelsBurger));
        abel.executeOrder();


        //TODO: RETURN ORDER
        //adam decides abels burger would be a better meal.

        BurgerOrderCommand adamsNewBurger = (BurgerOrderCommand) abelsBurger.clone();
        adamsNewBurger.shouldBeServedTo(adam);

        adam.changeOrder(new LogCommand(adamsNewBurger));
        adam.executeOrder();


        //TODO: BATCH ORDER
        //cain wants multiple things
        ArrayList<OrderCommand> cainsOrderList = new ArrayList<>();

        OrderCommand cainsBurger = new ChefsSpecialCommand(burgerChef);
        cainsOrderList.add(cainsBurger);

        OrderCommand cainsFries = new ChefsSpecialCommand(friesChef);
        cainsOrderList.add(cainsFries);


        BatchOrderCommand friesAndBurger = new BatchOrderCommand(cainsOrderList);

        friesAndBurger.shouldBeServedTo(cain);
        cain.setOrder(new LogCommand(friesAndBurger));
        cain.executeOrder();


        //TODO: RETURN LAST 3 ORDERS
        //A bad batch of ingredients were used in 3 last order
        OrderHistory.getInstance().undo();
        OrderHistory.getInstance().undo();
        OrderHistory.getInstance().undo();

        //redoing orders
        OrderHistory.getInstance().redo();
        OrderHistory.getInstance().redo();
        OrderHistory.getInstance().redo();

    }


}

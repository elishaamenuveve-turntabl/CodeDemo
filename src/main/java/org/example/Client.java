package org.example;

import org.example.command.*;
import org.example.command.regressor.LogCommand;
import org.example.command.regressor.RedoCommand;
import org.example.command.regressor.UndoCommand;
import org.example.invoker.Button;
import org.example.receiver.ShippingCompany;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        //TODO: CREATE INSTANCES OF RECEIVERS
        ShippingCompany ghanaShippingCompany = new ShippingCompany("Ghana Shipping Company");
        ShippingCompany africaShippingCompany = new ShippingCompany("Africa Shipping Company");
        ShippingCompany globalShippingCompany = new ShippingCompany("Global Shipping Company");

        //TODO: CREATE INSTANCES OF COMMAND
        ShipByLandCommand shipToPort = new ShipByLandCommand("Koforidua", "Tema", ghanaShippingCompany);
        ShipBySeaCommand shipToKenya = new ShipBySeaCommand("Tema, Ghana", "Kenya", africaShippingCompany);


        //TODO: CREATE INSTANCES OF INVOKERS
        Button toPort = new Button();
        toPort.setCommand(new LogCommand(shipToPort));

        Button toKenya = new Button();
        toKenya.setCommand(new LogCommand(shipToKenya));

        //TODO: INVOKE
        toPort.executeCommand();
        toKenya.executeCommand();

        //TODO: SHIP TO ANTARCTICA
        ArrayList<Command> shipFromGhanaToAntarctica = new ArrayList<>();
        shipFromGhanaToAntarctica.add(shipToPort);
        shipFromGhanaToAntarctica.add(shipToKenya);
        shipFromGhanaToAntarctica.add(new ShipByAirCommand("Kenya", "Antarctica", globalShippingCompany));

        Command toAntarctica = new ShipByTransitCommand(shipFromGhanaToAntarctica);

        //TODO: CREATE TRANSIT INVOKER AND INVOKE
        Button shipToAntarctica = new Button();
        shipToAntarctica.setCommand(new LogCommand(toAntarctica));

//        shipToAntarctica.executeCommand();





        //TODO: UNDO & REDO
        Button undoButton = new Button();
        undoButton.setCommand(new UndoCommand());

        Button redoButton = new Button();
        redoButton.setCommand(new RedoCommand());

        shipToPort.changeShippingDestination("Korle-bu");

        undoButton.executeCommand();
        undoButton.executeCommand();
//        redoButton.executeCommand();

    }


}

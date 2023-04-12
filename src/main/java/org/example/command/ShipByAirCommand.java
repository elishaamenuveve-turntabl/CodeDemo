package org.example.command;

import org.example.receiver.ShippingCompany;

public class ShipByAirCommand extends Command{
    private String origin;
    private String destination;
    private ShippingCompany shippingCompany;


    public ShipByAirCommand(String origin, String destination, ShippingCompany shippingCompany) {
        this.shippingCompany = shippingCompany;
        this.origin = origin;
        this.destination = destination;
    }

    public void changeShippingDestination(String destination) {
        this.destination = destination;
    }



    @Override
    public void execute() {
        System.out.println("Loading package onto plane...");
        shippingCompany.shipPackage(origin, destination);
        System.out.println("Package loaded off plane.\n");
    }

    @Override
    public void unexecute() {
        System.out.println("Loading package back onto plane");
        shippingCompany.shipPackage(destination, origin);
        System.out.println("Package returned to " + origin + "\n");
    }
}

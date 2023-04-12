package org.example.receiver;

public class ShippingCompany {
    private final String name;

    public ShippingCompany(String name) {
        this.name = name;
    }

    public void shipPackage(String source, String destination) {
        System.out.println("Package Shipped from " + source + " to " + destination + " by " + name);
    }
}

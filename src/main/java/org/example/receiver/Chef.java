package org.example.receiver;

public class Chef {
    private final String name;
    private String special = "Gari";

    public Chef(String name) {
        this.name = name;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getName() {
        return name;
    }

    public String getSpecial() {
        return special;
    }

    public void prepareOrder(String order) {
        System.out.println("Chef " + name + " prepares " + order);
    }
}

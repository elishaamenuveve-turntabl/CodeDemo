package org.example.command;

public abstract class Command implements Cloneable {

   public abstract void execute();
   public abstract void unexecute();


    @Override
    public Command clone() {
        try {
            return (Command) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

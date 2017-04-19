package com.pelensky.contactmanager;

public class DefaultOption implements Option {

    private CLInterface clInterface;

    DefaultOption(CLInterface clInterface){
        this.clInterface = clInterface;
    }

    @Override
    public void execute() {
        clInterface.printToConsole("Invalid selection");
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("default");
    }
}

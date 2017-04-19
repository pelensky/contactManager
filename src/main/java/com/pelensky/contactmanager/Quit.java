package com.pelensky.contactmanager;

public class Quit implements Option {

    private CLInterface clInterface;

    Quit(CLInterface clInterface) {
        this.clInterface = clInterface;
    }


    public void execute() {
        clInterface.setAppRunning(false);
        clInterface.printToConsole("Contact Manager Quitting");
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("quit");
    }
}

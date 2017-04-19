package com.pelensky.contactmanager;

public class Quit implements Option {

    private IO io;
    private CLInterface clInterface;

    Quit(IO io, CLInterface clInterface) {
        this.io = io;
        this.clInterface = clInterface;
    }


    public void execute() {
        clInterface.setAppRunning(false);
        io.printToConsole("Contact Manager Quitting");
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("quit");
    }
}

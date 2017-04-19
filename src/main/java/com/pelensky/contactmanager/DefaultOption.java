package com.pelensky.contactmanager;

public class DefaultOption implements Option {

    private IO io;

    DefaultOption(IO io){
        this.io = io;
    }

    @Override
    public void execute() {
        io.printText("Invalid selection");
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("default");
    }
}

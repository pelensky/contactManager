package com.pelensky.contactmanager;

public class Quit implements Option {

    private IO io;
    private AppRunner appRunner;

    Quit(IO io, AppRunner appRunner) {
        this.io = io;
        this.appRunner = appRunner;
    }


    public void execute() {
        appRunner.setAppNotRunning();
        io.printText("Contact Manager Quitting");
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("quit");
    }
}

package com.pelensky.contactmanager;

public class Quit implements Option {

    private IO io;
    private AppRunner appRunner;

    Quit(IO io, AppRunner appRunner) {
        this.io = io;
        this.appRunner = appRunner;
    }

    public String instruction() {
      return "Type `quit` to quit";
    }


    public void execute() {
        appRunner.setAppNotRunning();
        io.displayText("Contact Manager Quitting");
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("quit");
    }
}

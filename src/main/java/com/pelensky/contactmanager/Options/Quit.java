package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.CommandLineApp.AppRunner;
import com.pelensky.contactmanager.CommandLineApp.IO;

public class Quit implements Option {

    private IO io;
    private AppRunner appRunner;

    public Quit(IO io, AppRunner appRunner) {
        this.io = io;
        this.appRunner = appRunner;
    }

    public String instruction() {
      return "5) Quit";
    }


    public void execute() {
        appRunner.setAppNotRunning();
        io.displayText("Contact Manager Quitting");
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("5");
    }
}

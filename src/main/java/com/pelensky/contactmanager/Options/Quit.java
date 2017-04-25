package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.AppRunner;
import com.pelensky.contactmanager.IO;
import com.pelensky.contactmanager.Options.Option;

public class Quit implements Option {

    private IO io;
    private AppRunner appRunner;

    public Quit(IO io, AppRunner appRunner) {
        this.io = io;
        this.appRunner = appRunner;
    }

    public String instruction() {
      return "6) Quit";
    }


    public void execute() {
        appRunner.setAppNotRunning();
        io.displayText("Contact Manager Quitting");
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("6");
    }
}

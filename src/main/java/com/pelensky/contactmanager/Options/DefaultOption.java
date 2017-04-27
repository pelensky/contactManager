package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.CommandLineApp.IO;

public class DefaultOption implements Option {

    private IO io;

    public DefaultOption(IO io){
        this.io = io;
    }

    @Override
    public void execute() {
        io.displayText("Invalid selection");
    }

    @Override
    public String instruction() {
        return null;
    }
}

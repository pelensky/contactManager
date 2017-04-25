package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.IO;
import com.pelensky.contactmanager.Option;

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
    public boolean canRespondTo(String text) {
        return text.equals("default");
    }

    @Override
    public String instruction() {
        return null;
    }
}

package com.pelensky.contactmanager.Edit;

import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.Options.Option;

public abstract class EditOption implements Option {
    private final IO io;

    EditOption(IO io){
        this.io = io;
    }

    public void execute(){
        io.displayText("What would you like to change it to?");
        io.displayText(execute(io.getUserInput()));

    }

    public String instruction(){
        return get();
    }

    abstract String execute(String text);
    public abstract String get();
}


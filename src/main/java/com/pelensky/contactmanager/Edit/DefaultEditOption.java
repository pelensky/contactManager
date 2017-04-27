package com.pelensky.contactmanager.Edit;

import com.pelensky.contactmanager.CommandLineApp.IO;

public class DefaultEditOption extends EditOption{
    public DefaultEditOption(IO io) {
        super(io);
    }

    @Override
    public String execute(String text) {
        return "Invalid Selection";
    }

    @Override
    public String get() {
        return null;
    }

}

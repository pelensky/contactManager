package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.DisplayContacts;
import com.pelensky.contactmanager.IO;

class Commands {
    private IO io;
    private DisplayContacts displayContacts;

    Commands(IO io, DisplayContacts displayContacts) {
        this.io = io;
        this.displayContacts = displayContacts;
    }

    int selectContactTo(String text) {
        io.displayText(
                "Which contact would you like to " + text + "?"
                        + System.lineSeparator()
                        + "Please select number.");
        io.displayText(displayContacts.listContacts(displayContacts.getContacts()));
        return Integer.parseInt(io.getUserInput());
    }
}

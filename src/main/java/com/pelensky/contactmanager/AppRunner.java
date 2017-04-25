package com.pelensky.contactmanager;

import com.pelensky.contactmanager.Options.*;

import java.util.Arrays;
import java.util.List;

public class AppRunner {

    private Boolean appRunning = true;
    private ContactList contactList;
    private IO io;
    private ManipulateContacts manipulateContacts;

    AppRunner(ContactList contactList, IO io, ManipulateContacts manipulateContacts) {
        this.contactList = contactList;
        this.appRunning = true;
        this.io = io;
        this.manipulateContacts = manipulateContacts;
    }

    void runApp() {
        io.displayText("Contact Manager");
        while (appRunning) {
            io.displayText(appInstructions());
            makeSelection();
        }
    }

    private void makeSelection() {
        Option option = findOption(io.getUserInput());
        option.execute();
    }

    private List<Option> listOfOptions() {
        return Arrays.asList(
                new Add(io, contactList),
                new Search(io, contactList, manipulateContacts),
                new Show(io, contactList, manipulateContacts),
                new Edit(io, contactList, manipulateContacts),
                new Delete(io, contactList, manipulateContacts),
                new Quit(io, this));
    }

    private Option findOption(String selection) {
        for (Option o : listOfOptions()) {
            if (o.canRespondTo(selection.toLowerCase())) {
                return o;
            }
        }
        return new DefaultOption(io);
    }

    public void setAppNotRunning() {
        this.appRunning = false;
    }

    private String appInstructions() {
        String line = "----------------------------------------";
        StringBuilder instructions = new StringBuilder();
        for (Option o : listOfOptions()) {
            instructions.append(System.lineSeparator()).append(o.instruction());
        }
        return line + instructions + System.lineSeparator() + line;
    }

}

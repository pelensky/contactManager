package com.pelensky.contactmanager.CommandLineApp;

import com.pelensky.contactmanager.DomainModels.ContactList;
import com.pelensky.contactmanager.DomainServices.DisplayContacts;
import com.pelensky.contactmanager.Options.*;

import java.util.Arrays;
import java.util.List;

public class AppRunner {

    private Boolean appRunning = true;
    private ContactList contactList;
    private IO io;

    public AppRunner(ContactList contactList, IO io) {
        this.contactList = contactList;
        this.appRunning = true;
        this.io = io;
    }

    public void runApp() {
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
        DisplayContacts displayContacts = new DisplayContacts(contactList);
        Find find = new Find(io, contactList, displayContacts);
        return Arrays.asList(
                new Add(io, contactList),
                find,
                new Edit(io, displayContacts, find),
                new Delete(io, contactList, find),
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

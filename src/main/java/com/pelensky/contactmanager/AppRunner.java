package com.pelensky.contactmanager;

import java.util.Arrays;
import java.util.List;

class AppRunner {

    private Boolean appRunning = true;
    private ContactList contactList;
    IO io;

    AppRunner(ContactList contactList, IO io) {
        this.contactList = contactList;
        this.appRunning = true;
        this.io = io;
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
                new Show(io, contactList),
                new Edit(io, contactList),
                new Delete(io, contactList),
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

    void setAppNotRunning() {
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

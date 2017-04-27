package com.pelensky.contactmanager.CommandLineApp;

import com.pelensky.contactmanager.DomainModels.ContactList;
import com.pelensky.contactmanager.DomainServices.ManipulateContacts;
import com.pelensky.contactmanager.Options.*;
import com.pelensky.contactmanager.*;

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

    public void setAppNotRunning() {
        this.appRunning = false;
    }

    private void makeSelection() {
        int choice = Integer.parseInt(io.getUserInput());
        Option option = listOfOptions().get(choice - 1);
        option.execute();
    }

    private String appInstructions() {
        String line = "----------------------------------------";
//        StringBuilder instructions = new StringBuilder();
//        instructions.append(System.lineSeparator());
//        int currentIndex = 1;
//        for (Option o : listOfOptions()) {
//            instructions.append(currentIndex).append(") ");
//            instructions.append(o.instruction());
//            instructions.append(System.lineSeparator());
//            currentIndex++;
//        }
        Menu menu = new Menu(io, listOfOptions());
        String instructions = menu.printInstructions();
        return line + System.lineSeparator() + instructions + line;
    }

    private List<Option> listOfOptions() {
        ManipulateContacts manipulateContacts = new ManipulateContacts(contactList);
        Find find = new Find(io, manipulateContacts);
        return Arrays.asList(
                new Add(io, contactList),
                find,
                new Edit(io, manipulateContacts, find),
                new Delete(io, contactList, find),
                new Quit(io, this));
    }
}

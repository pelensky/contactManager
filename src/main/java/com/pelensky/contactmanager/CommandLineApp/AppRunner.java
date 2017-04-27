package com.pelensky.contactmanager.CommandLineApp;

import com.pelensky.contactmanager.DomainModels.ContactList;
import com.pelensky.contactmanager.DomainServices.ManipulateContacts;
import com.pelensky.contactmanager.Options.*;

import java.util.Arrays;
import java.util.List;

public class AppRunner {

    private Boolean appRunning = true;
    private ContactList contactList;
    private IO io;
    private Menu menu;

    public AppRunner(ContactList contactList, IO io) {
        this.contactList = contactList;
        this.appRunning = true;
        this.io = io;
        this.menu = new Menu(io, listOfOptions());
    }

    public void runApp() {
        io.displayText("Contact Manager");
        while (appRunning) {
           menu.selectAndExecute();
        }
    }

    public void setAppNotRunning() {
        this.appRunning = false;
    }
    private List<Option> listOfOptions() {
        ManipulateContacts manipulateContacts = new ManipulateContacts(contactList);
        Find find = new Find(io, manipulateContacts);
        return Arrays.asList(
                new Add(io, contactList),
                find,
                new Edit(io, contactList, find),
                new Delete(io, contactList, find),
                new Quit(io, this));
    }
}

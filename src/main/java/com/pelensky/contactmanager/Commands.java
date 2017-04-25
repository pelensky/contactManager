package com.pelensky.contactmanager;

public class Commands {
    private IO io;
    ContactList contactList;
    private ManipulateContacts manipulateContacts;

    public Commands(IO io, ContactList contactList, ManipulateContacts manipulateContacts) {
        this.io = io;
        this.contactList = contactList;
        this.manipulateContacts = manipulateContacts;
    }

    protected int selectContactTo(String text) {
        io.displayText(
                "Which contact would you like to " + text + "?"
                        + System.lineSeparator()
                        + "Please select number.");
        io.displayText(manipulateContacts.listContacts(contactList.getContacts()));
        return Integer.parseInt(io.getUserInput());
    }
}

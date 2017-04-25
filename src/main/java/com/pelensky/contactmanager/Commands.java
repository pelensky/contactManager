package com.pelensky.contactmanager;

class Commands {
    IO io;
    ContactList contactList;
    private ManipulateContacts manipulateContacts;

    Commands(IO io, ContactList contactList, ManipulateContacts manipulateContacts) {
        this.io = io;
        this.contactList = contactList;
        this.manipulateContacts = manipulateContacts;
    }

    int selectContactTo(String text) {
        io.displayText(
                "Which contact would you like to " + text + "?"
                        + System.lineSeparator()
                        + "Please select number.");
        io.displayText(manipulateContacts.listContacts(contactList.getContacts()));
        return Integer.parseInt(io.getUserInput());
    }
}

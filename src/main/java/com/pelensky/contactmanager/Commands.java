package com.pelensky.contactmanager;

class Commands {
    IO io;
    ContactList contactList;
    private DisplayContacts displayContacts;

    Commands(IO io, ContactList contactList, DisplayContacts displayContacts) {
        this.io = io;
        this.contactList = contactList;
        this.displayContacts = displayContacts;
    }

    int selectContactTo(String text) {
        io.displayText(
                "Which contact would you like to" + text + "?"
                        + System.lineSeparator()
                        + "Please select number.");
        io.displayText(displayContacts.listContacts());
        return Integer.parseInt(io.getUserInput());
    }
}

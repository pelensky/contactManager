package com.pelensky.contactmanager;

class Commands {
    IO io;
    ContactList contactList;

    Commands(IO io, ContactList contactList) {
        this.io = io;
        this.contactList = contactList;
    }

      boolean isContactListEmpty() {
        return contactList.isContactListEmpty();
    }

    boolean isNotAValidNumber(int selectedContact) {
        return contactList.isNotAValidNumber(selectedContact);
    }

    int selectContactTo(String text) {
        io.printText(
                "Which contact would you like to" + text + "?"
                        + System.lineSeparator()
                        + "Please select number.");
        io.printText(contactList.listContacts());
        return Integer.parseInt(io.getUserInput());
    }
}

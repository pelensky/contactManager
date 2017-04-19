package com.pelensky.contactmanager;

public class Show implements Option {

    private IO io;
    private ContactList contactList;

    Show(IO io, ContactList contactList) {
        this.io = io;
        this.contactList = contactList;
    }

    @Override
    public void execute() {
        if (contactList.isContactListEmpty()) {
            io.printText("No contacts to show");
        } else {
            io.printText("Show all contacts");
            io.printText(contactList.listContacts());
        }
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("show");
    }
}


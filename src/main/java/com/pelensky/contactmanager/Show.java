package com.pelensky.contactmanager;

public class Show implements Option {

    private CLInterface clInterface;
    private ContactList contactList;

    Show(CLInterface clInterface, ContactList contactList) {
        this.clInterface = clInterface;
        this.contactList = contactList;
    }

    @Override
    public void execute() {
        if (contactList.isContactListEmpty()) {
            clInterface.printToConsole("No contacts to show");
        } else {
            clInterface.printToConsole("Show all contacts");
            clInterface.printToConsole(contactList.listContacts());
        }
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("show");
    }
}


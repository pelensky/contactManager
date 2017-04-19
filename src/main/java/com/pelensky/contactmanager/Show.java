package com.pelensky.contactmanager;

public class Show implements Option {

    private CLInterface clInterface;
    ContactList contactList;

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
            clInterface.printContacts();
        }
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("show");
    }
}

package com.pelensky.contactmanager;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Search implements Option {

    IO io;
    ContactList contactList;
    private ManipulateContacts manipulateContacts;

    Search(IO io, ContactList contactList, ManipulateContacts manipulateContacts) {
        this.io = io;
        this.contactList = contactList;
        this.manipulateContacts = manipulateContacts;
    }

    @Override
    public void execute() {
        if (isContactListEmpty()) {
            io.displayText("No contacts");
        } else {
            io.displayText("Search for contact");
            String search = io.getUserInput().toUpperCase();
            ArrayList<Contact> filteredByFirstName = contactList.getContacts().stream().filter(contact -> contact.getFirstName().toUpperCase().equals(search)).collect(Collectors.toCollection(ArrayList::new));
            io.displayText(String.valueOf(filteredByFirstName));
        }
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("2");
    }

    @Override
    public String instruction() {
        return "2) Search for contact";
    }

    private boolean isContactListEmpty() {
        return manipulateContacts.isContactListEmpty();
    }

    private String listContacts() {
        return manipulateContacts.listContacts(contactList.getContacts());
    }


}

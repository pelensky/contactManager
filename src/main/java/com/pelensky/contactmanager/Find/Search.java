package com.pelensky.contactmanager.Find;

import com.pelensky.contactmanager.DomainModels.Contact;
import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.DomainServices.ManipulateContacts;

import java.util.ArrayList;

public class Search implements FindOption {

    private IO io;
    private ManipulateContacts manipulateContacts;

    public Search(IO io, ManipulateContacts manipulateContacts) {
        this.io = io;
        this.manipulateContacts = manipulateContacts;
    }

    @Override
    public Contact execute() {
        ArrayList<Contact> filteredContacts = findContacts();
        if (filteredContacts.isEmpty()) {
            return noContactsFound();
        } else {
            return getSelectedContact(filteredContacts);
        }
    }

    @Override
    public boolean canRespondTo(int number) {
        return number == 1;
    }

    private Contact getSelectedContact(ArrayList<Contact> filteredContacts) {
        int selection = selectContact(filteredContacts);
        if (selection > filteredContacts.size()) {
            return invalidSelection();
        } else {
            return getContact(filteredContacts, selection);
        }
    }

    private Contact getContact(ArrayList<Contact> filteredContacts, int selection) {
        return filteredContacts.get(selection - 1);
    }

    private Contact invalidSelection() {
        io.displayText("Invalid selection");
        return null;
    }

    private int selectContact(ArrayList<Contact> filteredContacts) {
        io.displayText("Select Contact");
        printFoundContacts(filteredContacts);
        return Integer.parseInt(io.getUserInput());
    }

    private Contact noContactsFound() {
        io.displayText("No match");
        return null;
    }

    private ArrayList<Contact> findContacts() {
        io.displayText("Search for contact");
        return searchForContacts();
    }


    private ArrayList<Contact> searchForContacts() {
        return manipulateContacts.filterContacts(io.getUserInput().toUpperCase());
    }

    private void printFoundContacts(ArrayList<Contact> filteredContacts) {
        io.displayText(String.valueOf(manipulateContacts.listContacts(filteredContacts)));
    }

}


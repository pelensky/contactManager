package com.pelensky.contactmanager.Find;

import com.pelensky.contactmanager.DomainModels.Contact;
import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.DomainServices.DisplayContacts;

import java.util.ArrayList;

public class Search implements FindOption {

    private IO io;
    private DisplayContacts displayContacts;

    public Search(IO io, DisplayContacts displayContacts) {
        this.io = io;
        this.displayContacts = displayContacts;
    }

    @Override
    public void executeForView() {
        ArrayList<Contact> filteredContacts = findContacts();
        if (filteredContacts.isEmpty()) {
            io.displayText("No match");
        } else {
            printFoundContacts(filteredContacts);
        }
    }

    @Override
    public Contact executeForManipulation() {
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
        return displayContacts.filterContacts(io.getUserInput().toUpperCase());
    }

    private void printFoundContacts(ArrayList<Contact> filteredContacts) {
        io.displayText(String.valueOf(filteredContacts.size()) + " Contact(s) Found");
        io.displayText(String.valueOf(displayContacts.listContacts(filteredContacts)));
    }

}


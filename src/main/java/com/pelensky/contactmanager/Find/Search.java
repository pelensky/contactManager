package com.pelensky.contactmanager.Find;

import com.pelensky.contactmanager.Contact;
import com.pelensky.contactmanager.IO;
import com.pelensky.contactmanager.DisplayContacts;

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
    public boolean canRespondTo(int number) {
        return number == 1;
    }

    @Override
    public Contact executeForManipulation() {
        ArrayList<Contact> filteredContacts = findContacts();
        if (filteredContacts.isEmpty()) {
            io.displayText("No match");
            return null;
        } else {
            io.displayText("Select Contact");
            printFoundContacts(filteredContacts);
            int selection = Integer.parseInt(io.getUserInput());
            if (selection > filteredContacts.size()){
                io.displayText("Invalid selection");
                return null;
            } else {
            return filteredContacts.get(selection - 1);
        }
        }
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

    private boolean isContactListEmpty() {
        return displayContacts.isContactListEmpty();
    }
}


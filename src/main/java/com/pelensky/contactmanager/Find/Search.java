package com.pelensky.contactmanager.Find;

import com.pelensky.contactmanager.Contact;
import com.pelensky.contactmanager.IO;
import com.pelensky.contactmanager.DisplayContacts;

import java.util.ArrayList;

public class Search implements FindOption  {

    private IO io;
    private DisplayContacts displayContacts;

    public Search(IO io, DisplayContacts displayContacts) {
        this.io = io;
        this.displayContacts = displayContacts;
    }

    @Override
    public void executeForView() {
        if (isContactListEmpty()) {
            io.displayText("No contacts");
        } else {
            io.displayText("Search for contact");
            ArrayList<Contact> filteredContacts = searchForContacts();
            if (filteredContacts.isEmpty()) {
                io.displayText("No match");
            } else {
                foundContacts(filteredContacts);
            }
        }
    }

    private void foundContacts(ArrayList<Contact> filteredContacts) {
        io.displayText(String.valueOf(filteredContacts.size()) + " Contact(s) Found");
        io.displayText(String.valueOf(displayContacts.listContacts(filteredContacts)));
    }

    @Override
    public boolean canRespondTo(int number) {
        return number == 1;
    }

    @Override
    public Contact executeForManipulation(){
       io.displayText("Search for contact");
       ArrayList<Contact> filteredContacts = searchForContacts();
       if (filteredContacts.isEmpty()) {
           io.displayText("No match");
           return null;
       } else {
           foundContacts(filteredContacts);
           return filteredContacts.get(0);
       }
    }

    private ArrayList<Contact> searchForContacts() {
        return displayContacts.filterContacts(io.getUserInput().toUpperCase());
    }

    private boolean isContactListEmpty() {
        return displayContacts.isContactListEmpty();
    }
}

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
    public void execute() {
        if (isContactListEmpty()) {
            io.displayText("No contacts");
        } else {
            io.displayText("Search for contact");
            ArrayList<Contact> filteredContacts = displayContacts.filterContacts(io.getUserInput().toUpperCase());
            if (filteredContacts.isEmpty()) {
                io.displayText("No match");
            } else {
                io.displayText(String.valueOf(filteredContacts.size()) + " Contact(s) Found");
                io.displayText(String.valueOf(displayContacts.listContacts(filteredContacts)));
            }
        }
    }


    @Override
    public boolean canRespondTo(int number) {
        return number == 1;
    }

    private boolean isContactListEmpty() {
        return displayContacts.isContactListEmpty();
    }
}

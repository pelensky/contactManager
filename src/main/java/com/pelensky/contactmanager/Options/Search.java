package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.Contact;
import com.pelensky.contactmanager.ContactList;
import com.pelensky.contactmanager.IO;
import com.pelensky.contactmanager.ManipulateContacts;
import com.pelensky.contactmanager.Options.Option;

import java.util.ArrayList;

public class Search implements Option {

    private IO io;
    private ContactList contactList;
    private ManipulateContacts manipulateContacts;

    public Search(IO io, ContactList contactList, ManipulateContacts manipulateContacts) {
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
            ArrayList<Contact> filteredContacts = manipulateContacts.filterContacts(search);
            if (filteredContacts.isEmpty()) {
                io.displayText("No match");
            } else {
                io.displayText(String.valueOf(filteredContacts.size()) + " Contact(s) Found");
                io.displayText(String.valueOf(manipulateContacts.listContacts(filteredContacts)));
            }
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


}

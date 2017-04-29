package com.pelensky.contactmanager.Find;

import com.pelensky.contactmanager.DomainModels.Contact;
import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.DomainServices.ManipulateContacts;

import java.util.ArrayList;

public class Show implements FindOption {

    private IO io;
    private ManipulateContacts manipulateContacts;

    public Show(IO io, ManipulateContacts manipulateContacts) {
        this.io = io;
        this.manipulateContacts = manipulateContacts;
    }

    @Override
    public boolean canRespondTo(int number) {
        return number == 2;
    }

    @Override
    public Contact execute() {
        io.displayText("Select Contact");
        io.displayText(listContacts());
        int selection = selectContact();
        return getContact(selection);
    }

    private Contact getContact(int selection) {
        if (selection > getContacts().size()) {
            io.displayText("Invalid selection");
            return null;
        } else {
            io.displayText(displayFormattedContact(selection));
            return getSelectedContact(selection);
        }
    }

    private String displayFormattedContact(int selection) {
        return manipulateContacts.displayFormattedContact(selection - 1, getContacts());
    }

    private Contact getSelectedContact(int selection) {
        return getContacts().get(selection - 1);
    }

    private String listContacts() {
        return manipulateContacts.listContacts(getContacts());
    }

    private ArrayList<Contact> getContacts() {
        return manipulateContacts.getContacts();
    }

    private int selectContact() {
        return Integer.parseInt(io.getUserInput());
    }
}

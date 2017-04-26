package com.pelensky.contactmanager.Find;

import com.pelensky.contactmanager.DomainModels.Contact;
import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.DomainServices.DisplayContacts;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class Show implements FindOption {

    private IO io;
    private DisplayContacts displayContacts;

    public Show(IO io, DisplayContacts displayContacts) {
        this.io = io;
        this.displayContacts = displayContacts;
    }

    @Override
    public void executeForView() {
        if (isContactListEmpty()) {
            io.displayText("No contacts to show");
        } else {
            io.displayText("Show all contacts");
            io.displayText(listContacts());
        }
    }

    @Override
    public boolean canRespondTo(int number) {
        return number == 2;
    }

    @Override
    public Contact executeForManipulation() {
        io.displayText(listContacts());
        io.displayText("Select Contact");
        int selection = selectContact();
        return getContact(selection);
    }

    private Contact getContact(int selection) {
        if (selection > getContacts().size()) {
            io.displayText("Invalid selection");
            return null;
        } else {
            return getSelectedContact(selection);
        }
    }

    private Contact getSelectedContact(int selection) {
        return getContacts().get(selection - 1);
    }

    private boolean isContactListEmpty() {
        return displayContacts.isContactListEmpty();
    }

    private String listContacts() {
        return displayContacts.listContacts(getContacts());
    }

    private ArrayList<Contact> getContacts() {
        return displayContacts.getContacts();
    }

    private int selectContact() {
        return Integer.parseInt(io.getUserInput());
    }
}

package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.DomainModels.Contact;
import com.pelensky.contactmanager.DomainModels.ContactList;
import com.pelensky.contactmanager.CommandLineApp.IO;

public class Add implements Option {

    private IO io;
    private ContactList contactList;

    public Add(IO io, ContactList contactList) {
        this.io = io;
        this.contactList = contactList;
    }

    public String instruction() {
        return "1) Add a new contact";
    }

    @Override
    public void execute() {
        io.displayText("Add a new contact");
        Contact newContact =
                new Contact(
                        addContactInfo("First Name: "),
                        addContactInfo("Last Name: "),
                        addContactInfo("Address (One Line): "),
                        addContactInfo("City: "),
                        addContactInfo("Postcode: "),
                        addContactInfo("Phone number: "));
        addContact(newContact);
        io.displayText(
                newContact.getFirstName()
                        + " "
                        + newContact.getLastName()
                        + " has been added as a contact.");
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("1");
    }


    private String addContactInfo(String text) {
        io.displayText(text);
        return io.getUserInput();
    }

    private void addContact(Contact newContact) {
        contactList.addContact((newContact));
    }
}

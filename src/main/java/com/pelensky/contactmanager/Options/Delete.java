package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.DomainModels.Contact;
import com.pelensky.contactmanager.DomainModels.ContactList;

public class Delete implements Option {

    private IO io;
    private ContactList contactList;
    private Find find;

    public Delete(IO io, ContactList contactList, Find find) {
        this.io = io;
        this.contactList = contactList;
        this.find = find;
    }

    @Override
    public String instruction() {
        return "4) Delete a contact";
    }

    @Override
    public void execute() {
        if (isContactListEmpty()) {
            noContacts();
        } else {
            Contact selectedContact = getContactToDelete();
            checkIfContactCanBeDeleted(selectedContact);
        }
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("4");
    }

    private void checkIfContactCanBeDeleted(Contact selectedContact) {
        if (selectedContact != null) {
            deleteSelectedContact(selectedContact);
        } else {
            io.displayText("Try again");
        }
    }

    private void deleteSelectedContact(Contact selectedContact) {
        delete(selectedContact);
        io.displayText("Deleted");
    }

    private Contact getContactToDelete() {
        io.displayText("Delete a contact");
        int selection = find.getChoiceForSearch();
        return find.findForManipulation(selection);
    }

    private void noContacts() {
        io.displayText("No contacts to delete");
    }

    private void delete(Contact selectedContact) {
        contactList.deleteContact(selectedContact);
    }

    private boolean isContactListEmpty() {
        return contactList.countContacts() < 1;
    }
}

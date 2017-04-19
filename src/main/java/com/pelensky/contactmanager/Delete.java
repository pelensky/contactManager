package com.pelensky.contactmanager;

public class Delete implements Option {

    private IO io;
    private ContactList contactList;

    Delete(IO io, ContactList contactList) {
        this.io= io;
        this.contactList = contactList;
    }

    @Override
    public void execute() {
        if (contactList.isContactListEmpty()) {
            io.printToConsole("No contacts to delete");
        } else {
            io.printToConsole("Delete a contact");
            DeleteContact deleteContact = new DeleteContact(contactList);
            int selectedContact = selectContactTo("delete");
            if (contactList.isNotAValidNumber(selectedContact)) {
                io.printToConsole("Contact does not exist\nTry again");
            } else {
                deleteContact.delete(selectedContact);
                io.printToConsole("Deleted");
            }
        }
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("delete");
    }

    private int selectContactTo(String action) {
        io.printToConsole("Which contact would you like to " + action + "?" + System.lineSeparator() + "Please select number.");
        io.printToConsole(contactList.listContacts());
        return Integer.parseInt(io.getUserInput());
    }

}

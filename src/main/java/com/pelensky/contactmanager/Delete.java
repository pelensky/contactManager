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
            io.printText("No contacts to delete");
        } else {
            io.printText("Delete a contact");
            DeleteContact deleteContact = new DeleteContact(contactList);
            int selectedContact = selectContactTo("delete");
            if (contactList.isNotAValidNumber(selectedContact)) {
                io.printText("Contact does not exist\nTry again");
            } else {
                deleteContact.delete(selectedContact);
                io.printText("Deleted");
            }
        }
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("delete");
    }

    private int selectContactTo(String action) {
        io.printText("Which contact would you like to " + action + "?" + System.lineSeparator() + "Please select number.");
        io.printText(contactList.listContacts());
        return Integer.parseInt(io.getUserInput());
    }

}

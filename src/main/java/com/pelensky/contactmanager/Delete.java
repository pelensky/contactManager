package com.pelensky.contactmanager;

public class Delete implements Option {

    private CLInterface clInterface;
    private ContactList contactList;

    Delete(CLInterface clInterface, ContactList contactList) {
        this.clInterface = clInterface;
        this.contactList = contactList;
    }

    @Override
    public void execute() {
        if (contactList.isContactListEmpty()) {
            clInterface.printToConsole("No contacts to delete");
        } else {
            clInterface.printToConsole("Delete a contact");
            DeleteContact deleteContact = new DeleteContact(contactList);
            int selectedContact = selectContactTo("delete");
            if (contactList.isNotAValidNumber(selectedContact)) {
                clInterface.printToConsole("Contact does not exist\nTry again");
            } else {
                deleteContact.delete(selectedContact);
                clInterface.printToConsole("Deleted");
            }
        }
    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("delete");
    }

    private int selectContactTo(String action) {
        clInterface.printToConsole("Which contact would you like to " + action + "?\nPlease select number.");
        clInterface.printContacts();
        return Integer.parseInt(clInterface.input.nextLine().trim());
    }

}

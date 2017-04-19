package com.pelensky.contactmanager;

public class Edit implements Option {

    private CLInterface clInterface;
    private ContactList contactList;

    Edit (CLInterface clInterface, ContactList contactList) {
        this.clInterface = clInterface;
        this.contactList = contactList;
    }

    @Override
    public void execute() {
        if (contactList.isContactListEmpty()) {
            clInterface.printToConsole("No contacts to edit");
        } else {
            clInterface.printToConsole("Edit a contact");
            EditContact editContact = new EditContact(contactList);
            int selectedContact = selectContactTo("edit");
            if (contactList.isNotAValidNumber(selectedContact)) {
                clInterface.printToConsole("Contact does not exist\nTry again");
            } else {
                int selectField = selectFieldToUpdate(selectedContact, editContact);
                updateField(editContact, selectField);
            }
        }

    }

    @Override
    public boolean canRespondTo(String text) {
        return text.equals("edit");
    }


    private int selectContactTo(String action) {
        clInterface.printToConsole("Which contact would you like to " + action + "?\nPlease select number.");
        clInterface.printToConsole(contactList.listContacts());
        return Integer.parseInt(clInterface.input.nextLine().trim());
    }

    private int selectFieldToUpdate(int selection, EditContact editContact) {
        clInterface.printToConsole("Which field would you like to edit?\n Please select number.");
        clInterface.printToConsole(editContact.showSelectionNumbers(selection));
        int selectField = Integer.parseInt(clInterface.input.nextLine().trim());
        clInterface.printToConsole("You have selected " + editContact.selectField(selectField));
        return selectField;
    }

    private void updateField(EditContact editContact, int selectField) {
        clInterface.printToConsole("What would you like to change it to?");
        String contactUpdate = clInterface.input.nextLine().trim();
        editContact.updateContact(selectField, contactUpdate);
        clInterface.printToConsole("Updated");
    }
}

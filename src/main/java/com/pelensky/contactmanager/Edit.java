package com.pelensky.contactmanager;

public class Edit implements Option {

    private IO io;
    private ContactList contactList;

    Edit (IO io, ContactList contactList) {
        this.io = io;
        this.contactList = contactList;
    }

    @Override
    public void execute() {
        if (contactList.isContactListEmpty()) {
            io.printText("No contacts to edit");
        } else {
            io.printText("Edit a contact");
            EditContact editContact = new EditContact(contactList);
            int selectedContact = selectContactTo("edit");
            if (contactList.isNotAValidNumber(selectedContact)) {
                io.printText("Contact does not exist" + System.lineSeparator() + "Try again");
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
        io.printText("Which contact would you like to " + action + "?" + System.lineSeparator() + "Please select number.");
        io.printText(contactList.listContacts());
        return Integer.parseInt(io.getUserInput());
    }

    private int selectFieldToUpdate(int selection, EditContact editContact) {
        io.printText("Which field would you like to edit?" + System.lineSeparator() + "Please select number.");
        io.printText(editContact.showSelectionNumbers(selection));
        int selectField = Integer.parseInt(io.getUserInput());
        io.printText("You have selected " + editContact.selectField(selectField));
        return selectField;
    }

    private void updateField(EditContact editContact, int selectField) {
        io.printText("What would you like to change it to?");
        String contactUpdate = io.input.nextLine().trim();
        editContact.updateContact(selectField, contactUpdate);
        io.printText("Updated");
    }
}

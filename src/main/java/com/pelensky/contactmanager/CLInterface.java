package com.pelensky.contactmanager;

import java.io.*;
import java.util.Scanner;


class CLInterface {

    private Scanner input;
    private PrintStream output;
    private String selectedOption;
    private Boolean appRunning = true;
    private ContactList contactList;

    CLInterface(Scanner input, PrintStream output, ContactList contactList) {
        this.input = input;
        this.output = output;
        this.contactList = contactList;
    }

    void runApp() {
        printToConsole("Contact Manager");
        while (appRunning) {
            printToConsole("Type `new` to add a new contact\nType `show` to display all contacts\nType `edit` to edit a contact\nType `quit` to quit.");
            makeSelection();
        }
    }

    private void makeSelection() {
        String selection = input.nextLine().toLowerCase().trim();
        switch (selection) {
            case "quit": selectedOption = "See you next time!";
                appRunning = false;
                printUsersSelection();
                break;
            case "new": selectedOption = "Add a new contact";
                printUsersSelection();
                addNewContact();
                break;
            case "show": selectedOption = "Show all contacts";
                printUsersSelection();
                showAllContacts();
                break;
            case "edit": selectedOption = "Edit a contact";
                printUsersSelection();
                editContact();
                break;
            default: selectedOption = "I didn't quite get that";
                printUsersSelection();
                break;
        }
    }

    private void addNewContact() {
        Contact newContact = new Contact(addFirstName(), addLastName(), addAddress(), addCity(), addPostCode(), addPhoneNumber());
        contactList.addContact(newContact);
        printToConsole(newContact.getFirstName() + " " + newContact.getLastName() + " has been added as a contact.");
    }

    private String addFirstName() {
        printToConsole("First Name: ");
        return input.nextLine().trim();
    }

    private String addLastName() {
        printToConsole("Last Name: ");
        return input.nextLine().trim();
    }

    private String addAddress() {
        printToConsole("Address (One Line):");
        return input.nextLine().trim();
    }

    private String addCity() {
        printToConsole("City: ");
        return input.nextLine().trim();
    }

    private String addPostCode() {
        printToConsole("Postcode:");
        return input.nextLine().trim();
    }

    private String addPhoneNumber() {
        printToConsole("Phone number:");
        return input.nextLine().trim();
    }

    private void editContact() {
        EditContact editContact = new EditContact(contactList);
        int selectField = selectFieldToUpdate(selectContactToEdit(), editContact);
        updateField(editContact, selectField);
    }

    private void updateField(EditContact editContact, int selectField) {
        printToConsole("What would you like to change it to?");
        String contactUpdate = input.nextLine().trim();
        editContact.updateContact(selectField, contactUpdate);
        printToConsole("Updated");
    }

    private int selectFieldToUpdate(int selection, EditContact editContact) {
        printToConsole("Which field would you like to edit?\n Please select number.");
        printToConsole(editContact.showSelectionNumbers(selection));
        int selectField = Integer.parseInt(input.nextLine().trim());
        printToConsole("You have selected " + editContact.selectField(selectField));
        return selectField;
    }

    private int selectContactToEdit() {
        printToConsole("Which contact would you like to edit?\nPlease select number.");
        showAllContacts();
        return Integer.parseInt(input.nextLine().trim());
    }

    private void showAllContacts() {
        printToConsole(contactList.listContacts());
    }

    private void printUsersSelection() {
        printToConsole(selectedOption);
    }

    private void printToConsole(String text) {
        output.println(text);
    }

}


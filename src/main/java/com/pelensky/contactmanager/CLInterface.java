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
        printToConsole("First Name: ");
        String firstName = input.nextLine().trim();
        printToConsole("Last Name: ");
        String lastName = input.nextLine().trim();
        printToConsole("Address (One Line):");
        String address = input.nextLine().trim();
        printToConsole("City: ");
        String city = input.nextLine().trim();
        printToConsole("Postcode:");
        String postCode = input.nextLine().trim();
        printToConsole("Phone number:");
        String phoneNumber = input.nextLine().trim();
        Contact newContact = new Contact(firstName, lastName, address, city, postCode, phoneNumber);
        printToConsole(newContact.getFirstName() + " " + newContact.getLastName() + " has been added as a contact.");
        contactList.addContact(newContact);
    }

    private void editContact() {
        printToConsole("Which contact would you like to edit?\nPlease select number.");
        showAllContacts();
        EditContact editContact = new EditContact(contactList);
        int selection = Integer.parseInt(input.nextLine().trim());
        printToConsole("Which field would you like to edit?\n Please select number.");
        printToConsole(editContact.showSelectionNumbers(selection));
        int selectField = Integer.parseInt(input.nextLine().trim());
        printToConsole("You have selected " + editContact.selectField(selectField));
        printToConsole("What would you like to change it to?");
        String contactUpdate = input.nextLine().trim();
        editContact.updateContact(selectField, contactUpdate);
        printToConsole("Updated");
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


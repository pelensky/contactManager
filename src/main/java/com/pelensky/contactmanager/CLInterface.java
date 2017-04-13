package com.pelensky.contactmanager;

import java.io.*;
import java.util.Scanner;


class CLInterface {

    Scanner input;
    PrintStream output;
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
            printToConsole("Type `new` to add a new contact\nType `quit` to quit.");
            makeSelection();
        }
    }


    private void printUsersSelection() {
        printToConsole(selectedOption);
    }

    private void makeSelection() {
        String selection = input.nextLine().toLowerCase();
        switch (selection) {
            case "quit": selectedOption = "See you next time!";
                appRunning = false;
                printUsersSelection();
                break;
            case "new": selectedOption = "Add a new contact";
                printUsersSelection();
                addNewContact();
                break;
            default: selectedOption = "I didn't quite get that";
                printUsersSelection();
                break;
        }
    }

    private void addNewContact() {
        printToConsole("First Name: ");
        String firstName = input.nextLine();
        printToConsole("Last Name: ");
        String lastName = input.nextLine();
        printToConsole("Address (One Line):");
        String address = input.nextLine();
        printToConsole("City: ");
        String city = input.nextLine();
        printToConsole("Postcode:");
        String postCode = input.nextLine();
        printToConsole("Phone number:");
        String phoneNumber = input.nextLine();
        Contact newContact = new Contact(firstName, lastName, address, city, postCode, phoneNumber);
        printToConsole(newContact.getFirstName() + " " + newContact.getLastName() + " has been added as a contact.");
        contactList.addContact(newContact);
    }

    private void printToConsole(String text) {
        output.println(text);
    }

}






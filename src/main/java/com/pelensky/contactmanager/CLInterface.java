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
        printWelcome();
        while (appRunning) {
            printSelections();
            makeSelection();
        }
    }

    private void printWelcome() {
        output.println("Contact Manager");
    }

    private void printSelections() {
        output.println("Type `new` to add a new contact\nType `quit` to quit.");
    }

    private void printUsersSelection() {
        output.println(selectedOption);
    }

    private void makeSelection() {
        String selection = input.next().toLowerCase();
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
        output.println("First Name: ");
        String firstName = input.next();
        output.println("Last Name: ");
        String lastName = input.next();
        output.println("Address (One Line):");
        String address = input.next();
        output.println("City: ");
        String city = input.next();
        output.println("Postcode:");
        String postCode = input.next();
        output.println("Phone number:");
        String phoneNumber = input.next();
        Contact newContact = new Contact(firstName, lastName, address, city, postCode, phoneNumber);
        output.println(newContact.getFirstName() + " " + newContact.getLastName() + " has been added as a contact.");
    }


}






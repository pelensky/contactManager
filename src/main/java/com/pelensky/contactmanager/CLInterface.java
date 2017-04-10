package com.pelensky.contactmanager;

import java.io.*;
import java.util.Scanner;


class CLInterface {

    Scanner input;
    PrintStream output;
    private String selectedOption;
    private Boolean appRunning = true;



    CLInterface(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
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
                addNewContact();
                break;
            default: selectedOption = "I didn't quite get that";
                printUsersSelection();
                break;
        }
    }

    private void addNewContact() {
        printUsersSelection();
    }


}






package com.pelensky.contactmanager;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class CLInterface {

  Scanner input;
  private PrintStream output;
  Boolean appRunning = true;
  private ContactList contactList;
  private Option add;
  private Option delete;
  private Option edit;
  private Option quit;
  private Option show;
  private Option defaultOption;

  CLInterface(Scanner input, PrintStream output, ContactList contactList) {
    this.input = input;
    this.output = output;
    this.contactList = contactList;
    this.appRunning = true;
  }

  void runApp() {
    printToConsole("Contact Manager");
    while (appRunning) {
      printInstructions();
      makeSelection();
    }
  }

  private List<Option> listOfOptions() {
    return Arrays.asList(
        add = new Add(this, contactList),
        delete = new Delete(this, contactList),
        edit = new Edit(this, contactList),
        quit = new Quit(this),
        show = new Show(this, contactList),
        defaultOption = new DefaultOption(this));
  }

  private Option findOption(String selection) {
     for (int i = 0; i < listOfOptions().size(); i ++ ) {
         if (listOfOptions().get(i).canRespondTo(selection)){
             return listOfOptions().get(i);
         }
     }
      return defaultOption;
  }

  private void makeSelection() {
    String selection = input.nextLine().toLowerCase().trim();
    Option option = findOption(selection);
    option.execute();
  }

  void printContacts() {
    printToConsole(contactList.listContacts());
  }

  private void printInstructions() {
    printToConsole("----------------------------------------");
    printToConsole(
        "Type `add` to add a new contact\nType `show` to display all contacts\nType `edit` to edit a contact\nType `delete` to delete a contact\nType `quit` to quit");
    printToConsole("----------------------------------------");
  }

  void printToConsole(String text) {
    output.println(text);
  }
}

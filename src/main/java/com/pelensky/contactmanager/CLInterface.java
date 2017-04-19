package com.pelensky.contactmanager;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class CLInterface {

  Scanner input;
  private PrintStream output;
  private Boolean appRunning = true;
  private ContactList contactList;

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

    private void makeSelection() {
        String selection = input.nextLine().toLowerCase().trim();
        Option option = findOption(selection);
        option.execute();
    }

  private List<Option> listOfOptions() {
    return Arrays.asList(
        new Add(this, contactList),
        new Delete(this, contactList),
        new Edit(this, contactList),
        new Show(this, contactList),
        new Quit(this));
  }

  private Option findOption(String selection) {
    for (int i = 0; i < listOfOptions().size(); i++) {
      if (listOfOptions().get(i).canRespondTo(selection)) {
        return listOfOptions().get(i);
      }
    }
    return new DefaultOption(this);
  }

  void setAppRunning(Boolean isAppRunning) {
    this.appRunning = isAppRunning;
  }

  private void printInstructions() {
    String line = "----------------------------------------";
    printToConsole(line);
    printToConsole(
        "Type `add` to add a new contact\nType `show` to display all contacts\nType `edit` to edit a contact\nType `delete` to delete a contact\nType `quit` to quit");
    printToConsole(line);
  }

  void printToConsole(String text) {
    output.println(text);
  }
}

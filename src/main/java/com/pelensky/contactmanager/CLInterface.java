package com.pelensky.contactmanager;

import java.util.Arrays;
import java.util.List;

class CLInterface {

  private Boolean appRunning = true;
  private ContactList contactList;
  private IO io;

  CLInterface(ContactList contactList, IO io) {
    this.contactList = contactList;
    this.appRunning = true;
    this.io = io;
  }

  void runApp() {
    io.printText("Contact Manager");
    while (appRunning) {
      io.printText(appInstructions());
      makeSelection();
    }
  }

  private void makeSelection() {
    Option option = findOption(io.getUserInput().toLowerCase());
    option.execute();
  }

  private List<Option> listOfOptions() {
    return Arrays.asList(
        new Add(io, contactList),
        new Delete(io, contactList),
        new Edit(io, contactList),
        new Show(io, contactList),
        new Quit(io, this));
  }

  private Option findOption(String selection) {
    for (int i = 0; i < listOfOptions().size(); i++) {
      if (listOfOptions().get(i).canRespondTo(selection)) {
        return listOfOptions().get(i);
      }
    }
    return new DefaultOption(io);
  }

  void setAppRunning(Boolean isAppRunning) {
    this.appRunning = isAppRunning;
  }

  private String appInstructions() {
    String line = "----------------------------------------";
    return line
        + System.lineSeparator()
        + "Type `add` to add a new contact"
        + System.lineSeparator()
        + "Type `show` to display all contacts"
        + System.lineSeparator()
        + "Type `edit` to edit a contact"
        + System.lineSeparator()
        + "Type `delete` to delete a contact"
        + System.lineSeparator()
        + "Type `quit` to quit"
        + System.lineSeparator()
        + line;
  }
}

package com.pelensky.contactmanager;

import java.io.*;
import java.util.Scanner;

class CLInterface {

  private Scanner input;
  private PrintStream output;
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
      printInstructions();
      makeSelection();
    }
  }

  private void makeSelection() {
    String selection = input.nextLine().toLowerCase().trim();
    switch (selection) {
      case "quit":
        quitApp();
        break;
      case "new":
        addNewContact();
        break;
      case "show":
        showAllContacts();
        break;
      case "edit":
        editContact();
        break;
      case "delete":
        deleteContact();
        break;
      default:
        selectDefault();
        break;
    }
  }

  private void quitApp() {
    printToConsole("See you next time!");
    appRunning = false;
  }

  private void selectDefault() {
    printToConsole("I didn't quite get that");
  }

  private void addNewContact() {
    printToConsole("Add a new contact");
    Contact newContact =
        new Contact(
            addFirstName(),
            addLastName(),
            addAddress(),
            addCity(),
            addPostCode(),
            addPhoneNumber());
    contactList.addContact(newContact);
    printToConsole(
        newContact.getFirstName()
            + " "
            + newContact.getLastName()
            + " has been added as a contact.");
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
    if (isContactListEmpty()) {
      printToConsole("No contacts to edit");
    } else {
      printToConsole("Edit a contact");
      EditContact editContact = new EditContact(contactList);
      int selectedContact = selectContactTo("edit");
      if (isNotAValidNumber(selectedContact)) {
        printToConsole("Contact does not exist\nTry again");
      } else {
        int selectField = selectFieldToUpdate(selectedContact, editContact);
        updateField(editContact, selectField);
      }
    }
  }

  private int selectContactTo(String action) {
    printToConsole("Which contact would you like to " + action + "?\nPlease select number.");
    printContacts();
    return Integer.parseInt(input.nextLine().trim());
  }

  private int selectFieldToUpdate(int selection, EditContact editContact) {
    printToConsole("Which field would you like to edit?\n Please select number.");
    printToConsole(editContact.showSelectionNumbers(selection));
    int selectField = Integer.parseInt(input.nextLine().trim());
    printToConsole("You have selected " + editContact.selectField(selectField));
    return selectField;
  }

  private void updateField(EditContact editContact, int selectField) {
    printToConsole("What would you like to change it to?");
    String contactUpdate = input.nextLine().trim();
    editContact.updateContact(selectField, contactUpdate);
    printToConsole("Updated");
  }

  private void deleteContact() {
    if (isContactListEmpty()) {
      printToConsole("No contacts to delete");
    } else {
      printToConsole("Delete a contact");
      DeleteContact deleteContact = new DeleteContact(contactList);
      int selectedContact = selectContactTo("delete");
      if (isNotAValidNumber(selectedContact)) {
        printToConsole("Contact does not exist\nTry again");
      } else {
        deleteContact.delete(selectedContact);
        printToConsole("Deleted");
      }
    }
  }

  private boolean isNotAValidNumber(int selectedContact) {
    return (selectedContact > numberOfContacts()) || (selectedContact < 1);
  }

  private boolean isContactListEmpty() {
    return contactList.getContacts().isEmpty();
  }

  private int numberOfContacts() {
      return contactList.countContacts();
  }

  private void showAllContacts() {
    if (isContactListEmpty()) {
      printToConsole("No contacts to show");
    } else {
      printToConsole("Show all contacts");
      printContacts();
    }
  }

  private void printContacts() {
    printToConsole(contactList.listContacts());
  }

  private void printInstructions() {
    printToConsole("----------------------------------------");
    printToConsole(
            "Type `new` to add a new contact\nType `show` to display all contacts\nType `edit` to edit a contact\nType `delete` to delete a contact\nType `quit` to quit");
    printToConsole("----------------------------------------");
  }

  private void printToConsole(String text) {
    output.println(text);
  }
}

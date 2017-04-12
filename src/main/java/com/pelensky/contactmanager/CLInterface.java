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
      printToConsole(
          "Type `new` to add a new contact\nType `show` to display all contacts\nType `edit` to edit a contact\nType `delete` to delete a contact\nType `quit` to quit");
      makeSelection();
    }
  }

  private void makeSelection() {
    String selection = input.nextLine().toLowerCase().trim();
    switch (selection) {
      case "quit":
        selectQuit();
        break;
      case "new":
        selectNew();
        break;
      case "show":
        selectShow();
        break;
      case "edit":
        selectEdit();
        break;
      case "delete":
        selectDelete();
        break;
      default:
        selectDefault();
        break;
    }
  }

  private void selectQuit() {
    printToConsole("See you next time!");
    appRunning = false;
  }

  private void selectNew() {
    printToConsole("Add a new contact");
    addNewContact();
  }

  private void selectShow() {
    showAllContacts();
  }

  private void selectEdit() {
    printToConsole("Edit a contact");
    editContact();
  }

  private void selectDelete() {
    printToConsole("Delete a contact");
    deleteContact();
  }

  private void selectDefault() {
    printToConsole("I didn't quite get that");
  }

  private void addNewContact() {
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
    EditContact editContact = new EditContact(contactList);
    int selectField = selectFieldToUpdate(selectContactTo("edit"), editContact);
    updateField(editContact, selectField);
  }

  private int selectContactTo(String action) {
    printToConsole("Which contact would you like to " + action + "?\nPlease select number.");
    showAllContacts();
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
    DeleteContact deleteContact = new DeleteContact(contactList);
    deleteContact.delete(selectContactTo("delete"));
    printToConsole("Deleted");
  }

  private void showAllContacts() {
    if (contactList.getContacts().isEmpty()) {
      printToConsole("No contacts to show");
    } else {
      printToConsole("Show all contacts");
      printToConsole(contactList.listContacts());
    }
  }

  private void printToConsole(String text) {
    output.println(text);
  }
}

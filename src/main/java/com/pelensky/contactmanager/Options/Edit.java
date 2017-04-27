package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.DomainServices.ManipulateContacts;
import com.pelensky.contactmanager.DomainModels.Contact;
import com.pelensky.contactmanager.Edit.*;

import java.util.Arrays;
import java.util.List;

public class Edit implements Option {

  private IO io;
  private ManipulateContacts manipulateContacts;
  private Find find;
  private Contact contact;

  public Edit(IO io, ManipulateContacts manipulateContacts, Find find) {

    this.io = io;
    this.manipulateContacts = manipulateContacts;
    this.find = find;
  }

  public String instruction() {
    return "Edit a contact";
  }

  @Override
  public void execute() {
    if (isContactListEmpty()) {
      noContacts();
    } else {
      editContactIfValid(getContactToEdit());
    }
  }

  private Contact getContactToEdit() {
    io.displayText("Edit a contact");
    int selection = find.getChoiceForSearch();
    return find.findForManipulation(selection);
  }

  private void editContactIfValid(Contact selectedContact) {
    if (selectedContact != null) {
    selectFieldToUpdate(selectedContact);
  } else {
      io.displayText("Try again");
    }
  }

  private void noContacts() {
    io.displayText("No contacts to edit");
  }

  private void selectFieldToUpdate(Contact contact) {
    io.displayText(
        "Which field would you like to edit?");
    io.displayText(showNumbersToEditOnContact(contact));
    int choice = Integer.parseInt(io.getUserInput());
    EditOption editOptions = listOfEditOptions().get(choice - 1);
    editOptions.execute();
  }

  private boolean isContactListEmpty() {
    return manipulateContacts.isContactListEmpty();
  }

  public String showNumbersToEditOnContact(Contact contact) {
    this.contact = contact;
    List<EditOption> contacts = listOfEditOptions();
    StringBuilder instructions = new StringBuilder();
    for (int i = 0; i < contacts.size(); i++){
      instructions.append(i).append(")").append(contacts.get(i)).append(System.lineSeparator());
    }
    return instructions.toString();
  }

  private List<EditOption> listOfEditOptions() {
    return Arrays.asList(
            new FirstName(io, contact),
            new LastName(io, contact),
            new Address(io, contact),
            new City(io, contact),
            new PostCode(io, contact),
            new PhoneNumber(io, contact));
  }

}

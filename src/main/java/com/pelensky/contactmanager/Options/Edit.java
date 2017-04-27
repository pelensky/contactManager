package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.CommandLineApp.Menu;
import com.pelensky.contactmanager.DomainModels.Contact;
import com.pelensky.contactmanager.DomainModels.ContactList;
import com.pelensky.contactmanager.Edit.*;

import java.util.Arrays;
import java.util.List;

public class Edit implements Option {

  private IO io;
  private ContactList contactList;
  private Find find;
  private Contact contact;

  public Edit(IO io, ContactList contactList, Find find) {

    this.io = io;
    this.contactList = contactList;
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
    editContact(selectedContact);
  } else {
      io.displayText("Try again");
    }
  }

  private void noContacts() {
    io.displayText("No contacts to edit");
  }

  private void editContact(Contact contact) {
    io.displayText(
        "Which field would you like to edit?");
    this.contact = contact;
    Menu menu = new Menu(io, listOfEditOptions());
    menu.selectAndExecute();
  }

  private boolean isContactListEmpty() {
    return contactList.isContactListEmpty();
  }

  private List<Option> listOfEditOptions() {
    return Arrays.asList(
            new FirstName(io, contact),
            new LastName(io, contact),
            new Address(io, contact),
            new City(io, contact),
            new PostCode(io, contact),
            new PhoneNumber(io, contact));
  }
}

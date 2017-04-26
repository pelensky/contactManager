package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.CommandLineApp.IO;
import com.pelensky.contactmanager.DomainServices.DisplayContacts;
import com.pelensky.contactmanager.DomainServices.EditContact;
import com.pelensky.contactmanager.DomainModels.Contact;

public class Edit implements Option {

  private IO io;
  private DisplayContacts displayContacts;
  private EditContact editContact;
  private Find find;

  public Edit(IO io, DisplayContacts displayContacts, Find find) {

    this.io = io;
    this.displayContacts = displayContacts;
    this.find = find;
  }

  public String instruction() {
    return "3) Edit a contact";
  }

  @Override
  public void execute() {
    if (isContactListEmpty()) {
      noContacts();
    } else {
      editContactIfValid(getContactToEdit());
    }
  }

  @Override
  public boolean canRespondTo(String text) {
    return text.equals("3");
  }

  private Contact getContactToEdit() {
    io.displayText("Edit a contact");
    int selection = find.getChoiceForSearch();
    return find.findForManipulation(selection);
  }

  private void editContactIfValid(Contact selectedContact) {
    editContact = new EditContact(selectedContact);
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
    io.displayText(editContact.showNumbersToEditOnContact(contact));
    updateField(Integer.parseInt(io.getUserInput()));
  }

  private void updateField(int selectField) {
    io.displayText("What would you like to change it to?");
    String contactUpdate = io.getUserInput();
    io.displayText(editContact.editField(selectField, contactUpdate));
  }

  private boolean isContactListEmpty() {
    return displayContacts.isContactListEmpty();
  }
}

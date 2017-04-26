package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.*;
import com.pelensky.contactmanager.EditContact;

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
      io.displayText("No contacts to edit");
    } else {
      io.displayText("Edit a contact");
      int selection = find.getChoiceForSearch();
      Contact selectedContact = find.findForManipulation(selection);
      editContact = new EditContact(selectedContact);
      if (selectedContact != null) {
      selectFieldToUpdate(selectedContact);
    } else {
        io.displayText("Try again");
      }
    }
  }

  @Override
  public boolean canRespondTo(String text) {
    return text.equals("3");
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

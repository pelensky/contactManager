package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.*;
import com.pelensky.contactmanager.EditContact;

public class Edit extends Commands implements Option {

  private IO io;
  private DisplayContacts displayContacts;
  private EditContact editContact;
  private Find find;

  public Edit(IO io, ContactList contactList, DisplayContacts displayContacts, Find find) {
    super(io, displayContacts);
    this.io = io;
    this.displayContacts = displayContacts;
    this.find = find;
    this.editContact = new EditContact(contactList);
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
      int selectedContact = selectContactTo("edit");
      if (displayContacts.isNotAValidNumber(selectedContact)) {
        io.displayText("Contact does not exist");
      } else {
        selectFieldToUpdate(selectedContact);
      }
    }
  }

  @Override
  public boolean canRespondTo(String text) {
    return text.equals("3");
  }

  private void selectFieldToUpdate(int selection) {
    io.displayText(
        "Which field would you like to edit?");
    io.displayText(showSelectionNumbers(selection));
    updateField(Integer.parseInt(io.getUserInput()));
  }

  private void updateField(int selectField) {
    io.displayText("What would you like to change it to?");
    String contactUpdate = io.getUserInput();
    io.displayText(editContact.editField(selectField, contactUpdate));
  }

  private String showSelectionNumbers(int selection) {
    return editContact.showSelectionNumbers(selection);
  }

  private boolean isContactListEmpty() {
    return displayContacts.isContactListEmpty();
  }
}

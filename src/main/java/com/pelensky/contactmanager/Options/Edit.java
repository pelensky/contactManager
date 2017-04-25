package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.*;
import com.pelensky.contactmanager.Edit.EditContact;

public class Edit extends Commands implements Option {

  private IO io;
  private ContactList contactList;
  private ManipulateContacts manipulateContacts;

  public Edit(IO io, ContactList contactList, ManipulateContacts manipulateContacts) {
    super(io, contactList, manipulateContacts);
    this.io = io;
    this.contactList = contactList;
    this.manipulateContacts = manipulateContacts;
  }

  public String instruction() {
    return "4) Edit a contact";
  }

  @Override
  public void execute() {
    if (manipulateContacts.isContactListEmpty()) {
      io.displayText("No contacts to edit");
    } else {
      io.displayText("Edit a contact");
      EditContact editContact = new EditContact(contactList);
      int selectedContact = selectContactTo("edit");
      if (manipulateContacts.isNotAValidNumber(selectedContact)) {
        io.displayText("Contact does not exist");
      } else {
        selectFieldToUpdate(selectedContact, editContact);

      }
    }
  }

  @Override
  public boolean canRespondTo(String text) {
    return text.equals("4");
  }

  private void selectFieldToUpdate(int selection, EditContact editContact) {
    io.displayText(
        "Which field would you like to edit?" + System.lineSeparator() + "Please select number.");
    io.displayText(editContact.showSelectionNumbers(selection));
    int selectField = Integer.parseInt(io.getUserInput());
    io.displayText("What would you like to change it to?");
    String contactUpdate = io.getUserInput();
    io.displayText(editContact.editField(selectField, contactUpdate));
  }

}

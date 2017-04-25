package com.pelensky.contactmanager.Options;

import com.pelensky.contactmanager.ContactList;
import com.pelensky.contactmanager.IO;
import com.pelensky.contactmanager.ManipulateContacts;
import com.pelensky.contactmanager.Options.Option;

public class Show implements Option {

  private IO io;
  private ContactList contactList;
  private ManipulateContacts manipulateContacts;

  public Show(IO io, ContactList contactList, ManipulateContacts manipulateContacts) {
    this.io = io;
    this.contactList = contactList;
    this.manipulateContacts = manipulateContacts;
  }

  public String instruction() {
    return "3) Show all contacts";
  }

  @Override
  public void execute() {
    if (isContactListEmpty()) {
      io.displayText("No contacts to show");
    } else {
      io.displayText("Show all contacts");
      io.displayText(listContacts());
    }
  }

  @Override
  public boolean canRespondTo(String text) {
    return text.equals("3");
  }

  private boolean isContactListEmpty() {
    return manipulateContacts.isContactListEmpty();
  }

  private String listContacts(){
      return manipulateContacts.listContacts(contactList.getContacts());
  }
}

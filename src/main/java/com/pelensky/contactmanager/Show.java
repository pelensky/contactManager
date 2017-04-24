package com.pelensky.contactmanager;

public class Show implements Option {

  private IO io;
  private ContactList contactList;
  private ManipulateContacts manipulateContacts;

  Show(IO io, ContactList contactList, ManipulateContacts manipulateContacts) {
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

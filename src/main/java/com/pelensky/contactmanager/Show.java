package com.pelensky.contactmanager;

public class Show implements Option {

  private IO io;
  private ContactList contactList;
  private DisplayContacts displayContacts;

  Show(IO io, ContactList contactList, DisplayContacts displayContacts) {
    this.io = io;
    this.contactList = contactList;
    this.displayContacts = displayContacts;
  }

  public String instruction() {
    return "2) Show all contacts";
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
    return text.equals("2");
  }

  private boolean isContactListEmpty() {
    return contactList.isContactListEmpty();
  }

  private String listContacts(){
      return displayContacts.listContacts();
  }
}

package com.pelensky.contactmanager;

public class Show implements Option {

  private IO io;
  private ContactList contactList;

  Show(IO io, ContactList contactList) {
    this.io = io;
    this.contactList = contactList;
  }

  public String instruction() {
    return "Type `show` to display all contacts";
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
    return text.equals("show");
  }

  private boolean isContactListEmpty() {
    return contactList.isContactListEmpty();
  }

  private String listContacts(){
      return contactList.listContacts();
  }
}

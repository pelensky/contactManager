package com.pelensky.contactmanager.Find;

import com.pelensky.contactmanager.Contact;
import com.pelensky.contactmanager.IO;
import com.pelensky.contactmanager.DisplayContacts;

import java.util.ArrayList;

public class Show implements FindOption {

  private IO io;
  private DisplayContacts displayContacts;

  public Show(IO io, DisplayContacts displayContacts) {
    this.io = io;
    this.displayContacts = displayContacts;
  }

  @Override
  public void executeForView() {
    if (isContactListEmpty()) {
      io.displayText("No contacts to show");
    } else {
      io.displayText("Show all contacts");
      io.displayText(listContacts());
    }
  }

  @Override
  public boolean canRespondTo(int number) {
    return number == 2;
  }

  @Override
  public Contact executeForManipulation() {
    io.displayText(listContacts());
    if (getContacts().size() > 1) {
      io.displayText("Select Contact");
      return getContacts().get(selectContact() - 1);
    } else {
      return getContacts().get(0);
    }
  }

  private boolean isContactListEmpty() {
    return displayContacts.isContactListEmpty();
  }

  private String listContacts(){
      return displayContacts.listContacts(getContacts());
  }

  private ArrayList<Contact> getContacts() {
    return displayContacts.getContacts();
  }

  private int selectContact() {
   return Integer.parseInt(io.getUserInput());
  }
}
